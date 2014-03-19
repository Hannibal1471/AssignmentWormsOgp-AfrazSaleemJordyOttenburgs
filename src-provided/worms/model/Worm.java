package worms.model;

import be.kuleuven.cs.som.annotate.Basic;

/**
 * 
 * @author Afraz Salim and Jordy Ottenburgs
 *
 */
public class Worm {
	private double x;
	private double y;
	private double radius;
	private double direction;
	private String name;
	private double mass;
	private double ActionPoints;
	int ActionCost;
	
	
	/**
	 * Constructor to initialise the variable with their initial value.
	 * 
	 * @param rx
	 * 			The position of the worm at x-Axis.
	 * @param ry
	 *          The position of the worm at y-axis.
	 * @param rdirection
	 *          The direction of the worm .
	 * @param rradius
	 *          The radius of the worm.
	 * @param rname
	 *          Name of the worm.
	 * @post...
	 *         The x variable will be initialised with it,s initial value.
	 * @post...
	 *         The Y variable will be initialised with it,s initial value.
	 * @post...
	 *         The variable for direction will be initialised with it,s initial value.
	 * @post...
	 *         The worm will get an initial radius.
	 * @post...
	 *         The worm,s name will be initialised with it,s name.Worm,s get their names.
	 */
	public Worm(double rx, double ry, double rdirection, double rradius, String rname)
	{
		this.x = rx;
		this.y = ry;
		this.direction = rdirection;
		this.radius = rradius;
		this.name = rname;
	}
	
	/**
	 * To get the position of the worm at x-coordinate.
	 * @return
	 *       The position of the worm at x-axis.
	 *       (result = (position at x-axis)).
	 *       |return this.getX()
	 */
	@Basic
	public double getX()
	{
		return this.x;
	}
	
	/**
	 * To get the position of the worm at Y-coordinate.
	 * @return
	 *         It returns the position of the worm worm at y-axis.
	 *         (result= (position at y-axis))
	 *         |return this.getY()
	 */
	@Basic
	public double getY()
	{
		return this.y;
	}
	
	
	/**
	 * To set the position of the worm at X-axis.
	 * @param xcoordinate
	 *               To update the value of the variable at x-axis.it updates the value
	 *               of the x-coordinate when the new value is assigned or when any action 
	 *               is performed.
	 *               |this.x = new.xCoordinate
	 */
	public void setX(double xCoordinate)
	{
		this.x = xCoordinate;
	}
	
	
	/**
	 * To set the position of the worm at y-axis.
	 * @param yCoordinate
	 *           To set the value of the variable at y-axis.The value of the y-coordinate will be updated 
	 *           when a new value will be assigned to the worm or when the action will be performed by 
	 *           jumping or moving.
	 *           |this.y = new.yCoordinate;
	 */
	public void setY(double yCoordinate)
	{
		this.y = yCoordinate;
	}
	
	
	
	/**
	 * To move along the axis with given number of steps and according to the angle.
	 *   
	 * @param nbSteps
	 *            The given number of steps.
	 * @post.... 
	 *            Set the new position of the worm at x coordinate.
	 *            |this.setX(nbStepsOnXcoordinate).
	 * @post...
	 *            Set the new position of the worm at y-Axis.
	 *            |this.setY(nbStepsOnYcoordinate).
	 * @post ....
	 *            The actioncost, required to move, will be subtracted from the total ActionPoints.
	 *            |this.setActionPoints(ActionCost).
	 * @effect...
	 *            The worm will move the number of steps, it is given on the x and y axis and the 
	 *            the cost to walk will be decremented from the total action points.
	 */
	public void move(int nbSteps)
	{
		double nbStepsOnXcoordinate = this.getX()+nbSteps*this.getRadius()*Math.cos(this.getDirection());
		double nbStepsOnYcoordinate = this.getY()+nbSteps*this.getRadius()*Math.sin(this.getDirection());
		ActionCost = (int) (this.getActionPoints() - nbSteps*(Math.abs((Math.cos(this.getDirection())))+Math.abs(4*Math.sin(this.getDirection()))));
		this.setX(nbStepsOnXcoordinate);
		this.setY(nbStepsOnYcoordinate);
		this.setActionPoints((int)ActionCost);
	}
	
	
	
	/**
	 * To set the ActionPoints and to update the action Points.
	 * @param newActionPoints
	 *          The initial Action points are awarded to the worm and will be 
	 *          updated according to it's mass.
	 *@post....
	 *         The Action points will be initialised and then updated with the newActionPoints.
	 *         |this.ActonPoints  new.ActionPoints.
	 */
	public void setActionPoints(int newActionPoints){
		this.ActionPoints = newActionPoints;
	}

	
	
	/**
	 * set,s the position of the worm on x-axis and y-axis.
	 * @param coo
	 *        An array to save the values of X and Y axis to keep the worm at a certain 
	 *        position after jumping.
	 * @post...
	 *        Sets the new position of the worm at x-axis when the jump action will be
	 *        performed by the worm.
	 *       |this.setX() = new.coo[0].
	 * @post...
	 *       Sets the new position of the worm at y-axis when the jump action will be 
	 *       performed by the worm.
	 *       |this.setY() = new.coo[1].
	 */
	public void actionJump(double[] coo)
	{
		this.setX(coo[0]);
		this.setY(coo[1]);
	}
	
	
	/**
	 * To turn in the given direction.
	 * @param angle
	 *         to turn according to this given angle.
	 * @post ...
	 *         Sets the direction of the worm to the given angle.
	 *         |this.setDirection(getDirection() + angle)
	 *@post...
	 *         Action points for turning will be subtracted from the initial actionpoints.
	 *         |this.setActionPoints(ActionPointsAfterTurn).
	 */
	public void turn(double angle)
	{
			this.setDirection(getDirection() + angle);
			double fraction = 2*Math.PI/angle; 
			double ActionPointsAfterTurn = this.getActionPoints()-(60/Math.abs(fraction));
			this.setActionPoints((int)ActionPointsAfterTurn);
	}
	
	/**
	 * Gets the radius of the worm.
	 * @return
	 *        It return the radius of the worm .
	 *        (result = (radius)).
	 *        |return this.radius
	 */
	@Basic
	public double getRadius(){
		return this.radius;
	}
	
	/**
	 * 
	 * @param Radius
	 *         Parameter to update or set the radius of the worm.
	 * @post ....
	 *         Sets the radius to the new radius
	 *         |this.radius = new.radius
	 */
	public void setRadius(double Radius)
	{
		this.radius = Radius;
		
	}
	
	/**
	 * 
	 * @return
	 *      The minimal radius of the worm.
	 *      (result = (minimalRadius)).
	 *      |return = minimalRadius.
	 */
	@Basic
	public double getMinimalRadius()
	{
		double minimalRadius = 0.25;
		return minimalRadius;
	}
	
	
	/**
	 * 
	 * @return
	 *     The direction of the worm.
	 *     (result = (this.direction))
	 *     |return this.direction
	 */
	@Basic
	public double getDirection()
	{
		return this.direction;
	}
	
	
	/**
	 * 
	 * @param newDirection
	 *          Direction/angle of the worm.
	 * @post....
	 *         It sets the new direction of the worm according to the 
	 *         given angle.
	 *         |this.Direction = new.newDirection.
	 */
	public void setDirection(double newDirection)
	{
		this.direction = newDirection;
	}
	
	
	/**
	 * 
	 * @return
	 *      Gets the name of the worm.
	 *      (result = (name))
	 *      |result = (this.name).
	 */
    @Basic
	public String getName()
	{
		return this.name;
	}
	
	
	/**
	 *  To set the name of the worm.
	 * @param Name
	 *        new Name of the worm. 
	 * @post...
	 *       Replaces the old name with a new name if the new name 
	 *       is a valid name.
	 *       |this.name = new.name.
	 */
	public void setName(String Name)
	{
		this.name = Name;
	}
	
	
	
	

	
	
	/**
	 *   The total mass of the worm will be calculated according to it,s radius.
	 * @return
	 *        It returns the total mass of the worm.
	 *        (result = (mass)).
	 *        |this.getMass() = mass.
	 */
	public double getMass()
	{
		mass = 1062*((1.33)*Math.PI*Math.pow(this.getRadius(), 3));
		return mass;
	}
	
	
	/**
	 * Gets the ActionPoints of the worm.
	 * @return
	 *          It returns the action points of the worm.
	 *          (result = (ActionPoints))
	 *          |return ActionPoints.
	 */
	public int getActionPoints()
	{
		return (int) ActionPoints;
	}
	
	
    /**
     * Gets the initial ActionPoints which are equal to the worm,s mass.
     * @return
     *          It returns the initialAction points which are equal to the mass of the worm rounded to the highest integer.
     *          (result = (ActionPoints))
     *          |return ActionPoints.
     */
	public int getInitialActionPoints()
	{
		int initialpoints = (int) this.getMass();
		return initialpoints;
	}
	
	/**
	 * Computes the force, need a worm to jump according to this force.
	 * @return
	 *      It returns the force required by the worm according to its action points and mass.
	 *      result = (force).
	 *      |return force.
	 */
	public double getForce(){
		double force = (5*this.getActionPoints())+(this.getMass()*9.80665);
		return force;
	}
	
	
	/**
	 * It computes the initial velocity of the worm.
	 * @return
	 *     it return the the initial velocity of the worm.
	 *     result = (velocity).
	 *     |return velocity.
	 */
	public double initialVelocity(){
		double velocity;
		velocity = (this.getForce()/this.getMass())*0.5;
		return velocity;
	}
	
	/**
	 * To compute the distance.
	 * @return
	 *     it returns the distance that the worm will jump.
	 *     |distance = (Math.pow(this.initialVelocity(), 2)*Math.sin(2*this.getDirection()))/gravity.
	 */
	public double getDistance(){
		double distance = (Math.pow(this.initialVelocity(), 2)*Math.sin(2*this.getDirection()))/9.80665;
		return distance;

	}
	
	/**
	 * Computes the total time while jumping.
	 * @return
	 *       The time of the jump.
	 *       result = (time)
	 *       |return time.
	 */
	public double getJumpTime()
	{
		double	time = this.getDistance()/(this.initialVelocity()*Math.cos(this.getDirection()));
		return time;
	}
	
	
	
	/**
	 * 
	 * @param Time
	 *         The time of the jump step.
	 * @return
	 *       The total velocity of the worm will be computed, then this velocity
	 *       will be used by a worm to calculate its jump steps at a certain
	 *       distance at x and y coordinate.
	 *       (result = (Array containing the value s of x and y coordinate.))
	 *       |return Array.
	 */
	public double[] getJumpStep(double Time)
	{
		double velocityx = this.initialVelocity() * Math.cos(this.getDirection());
		double velocityy = this.initialVelocity()* Math.sin(this.getDirection());
		double xCoValue = this.getX()+ (velocityx*Time);
	    double yCoValue = this.getY()+ (velocityy*Time-(0.5)*9.80665*Math.pow(Time, 2));
		double[] Array = new double[2];
		Array[0] = xCoValue;
		Array[1] = yCoValue;
		return Array;
	}
	
	/**
	 * Checks wether the remaining ActionPoints are valid or not.
	 * @return
	 *       True if and only if the action points are greater than zero. If the given number of the action points 
	 *       is less than zero it will return false.
	 *       (result = (true) if ActionPoints are greater than 0)
	 *       |this.getActionPoints()>0.
	 */
	@Basic
	public boolean hasValidActionPoints()
	{
		if (this.getActionPoints()>0)
		return true;
			if(this.getActionPoints()<0)
			this.setActionPoints(0);
		return false;
	}
	
	
	
	

	
	
	/**
	 * Checks whether the radius is valid or not.
	 * @param radius
	 *          
	 * @return
	 *  The given radius to check whether it is valid or not.
	 *          Radius should be greater then MinimalRadius.
	 *          True if the radius is valid. 
	 *          |(radius>=this.getMinimalRadius()).
	 */
	@Basic
	public boolean isValidRadius(double radius)
	{
		if(radius>=this.getMinimalRadius())
		{
		return true;
		}
		return false;
	}
	
	/**
	 * To call the actionJump method with the value,s so that the worm can jum.
	 *@post ...
	 *        The worm will jump.
	 *        |this.actionJump(getJumpStep(getJumpTime()).
	 *@effect...
	 *        The worm will change its position by jumping from one place to oneother,
	 *        with a certain force, only if the worm has enough action points to jump.
	 *        It uses a certain number of the steps and time during the jump.
	 */
	public void Jump()
	{
		this.actionJump(getJumpStep(getJumpTime()));	
	}
	
	
	/**
	 * Checks whether the new name is valid or not.
	 * @param name
	 *        To replace the old name with new name.
	 * @return..
	 *       The name of the worm should not be empty.
	 *       |!name.isEmpty().
	 *       Checks if the name contains any integer. It will than result in false.
	 *       |name.conatains(number).
	 *       The name of the worm should not contain any symbol.
	 *       |(!(name.contains(symbol)).
	 *       Checks whether the new name contains any space or not.if the name does not contain any 
	 *       space.it will than result in false.
	 *       |(name.contains(" "))
	 *       The first character of the worm's name should be a capital. If the first character of the 
	 *       name is not in upper case the condition will be false.
	 *       |(Character.isUpperCase(name.charAt(0))).
	 */
	 @Basic
	public boolean isValidName(String name)
	{
		String [] signs = { ":", "%","£","*","^",")","(","+","-","!","'","&","|"};
        String[] num = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };  
		for(int i = 0;i< num.length;i++)
			if(name.contains(num[i])&&(name.contains(num[i]))){
				return false;
			}
		for(int i = 0;i < signs.length;i++){
			if(name.contains(signs[i]))
				return false;
		}
		if(name.isEmpty())
			return false;
		if(!Character.isUpperCase(name.charAt(0)))
			return false;
		if(!name.contains(" "))
			return false;
		
		return true;
	}
	
	/**
	 * Checks whether the worm can jump or not. It,s given angle is valid or not. 
	 * @return  
	 *    True if and only if the direction of the worm is valid. If the direction of the worm is 
	 *    towards the down side and if the worm will be prompted to jump it will return false.
	 *    |!(this.getDirection()>Math.PI &&this.getDirection()< 2*Math.PI)
	 */
	@Basic
	public boolean canJump(){
		if(!(this.getDirection()>Math.PI &&this.getDirection()< 2*Math.PI))
			return true;
		else
		return false;
	  }
	
}
