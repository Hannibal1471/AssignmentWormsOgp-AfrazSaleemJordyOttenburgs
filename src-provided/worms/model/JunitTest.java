package worms.model;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class JunitTest {

	private Worm worm;
	Facade facade;
	
	
	@Before
	public void setUp(){
	worm = new Worm(6,10,6,6,"A K");
	
	}
	@Test
	public void Constructor_values() throws Exception{
		assertEquals(6,worm.getX(),0);
		assertEquals(10,worm.getY(),0);
		assertEquals(6,worm.getDirection(),0);
		assertEquals(6,worm.getRadius(),0);
        assertEquals("A K",worm.getName());
	}

	    @Test
	    public void nameEquivalence_trueCase(){
	      assertEquals("A K",worm.getName());
	    }
	     
	     @Test
	     public void ActionPoints_EqualCase(){
	    	 worm.setActionPoints(160);
		    assertEquals(160,worm.getActionPoints(),0);
	     }
	     
	     @Test
	     public void nameTest_EqualCase(){
	    	worm.setName("Jordy Ottenburgs");
			assertEquals("Jordy Ottenburgs",worm.getName());
	     }
	     
	     @Test
	     public void isValidName_trueCase(){
			assertTrue(worm.isValidName("Johnson Bart"));
	     }
	     @Test
	     public void isValidRadius_trueCase(){
			assertTrue(worm.isValidRadius(0.25));
	     }
		
	     @Test
	     public void turelegalCAse_falseCase(){
	    	 assertFalse(worm.isValidRadius(0.05));
	     }
	     
	     @Test
	     public void coordinatesCase_trueCase(){
	    	worm.setX(7);
			assertEquals(7,worm.getX(),0);
	     }
	     
	     @Test
	     public void coordinateCase_truCase(){
	    	 worm.setY(8);
			assertEquals(8,worm.getY(),0);
	     }
	     
	     @Test
	     public void setRadiusCase_trueCase(){
             worm.setRadius(0.25);
             assertEquals(0.25,worm.getRadius(),0);
	     }
	     
	     @Test
	     public void minimalRadius_TrueCase(){
	    	 assertEquals(0.25,worm.getMinimalRadius(),0);
	     }
	     
	     @Test
	     public void directionTest_trueCase(){
	       worm.setDirection(9);
		   assertEquals(9,worm.getDirection(),0);
	     }
	     
	     @Test(expected = NullPointerException.class)
	     public void exceptionTestCaseMove_ThrowAbleCae(){ //throws NullPointerException{
	      facade.turn(worm, 3.14);
	      throw new NullPointerException("Can,t move now");
	     }
	 
}


	

	
	

