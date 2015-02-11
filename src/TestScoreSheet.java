import java.util.Comparator;
import junit.framework.TestCase;

public class TestScoreSheet extends TestCase{
//	
	private ScoreSheet ss1;
//	
	private ScoreSheet ss2;
//	
	private ScoreSheet ss3;
	public void testOneThrow(){
		ss1=new ScoreSheet();
		ss2=new ScoreSheet();
		ss3=new ScoreSheet();
		
		ss1.addThrow(0);
		ss2.addThrow(5);
		ss3.addThrow(9);
		
		assertTrue(ss1.getFrame()==2);
		assertTrue(ss2.getFrame()==1);
		assertTrue(ss3.getFrame()==1);
		assertTrue(ss2.getFrame(1).getCurrentTurn() == 1); //0-1
		assertTrue(ss3.getFrame(1).getCurrentTurn()==1);
		
		assertEquals(ss1.getScore(), 0);
		assertEquals(ss2.getScore(), 0);
		assertEquals(ss3.getScore(), 0);
		
		ss2.addThrow(0);
		ss3.addThrow(1);
		
		assertTrue(ss2.getFrame()==2);
		assertTrue(ss3.getFrame()==2);
		
		assertEquals(ss2.getScore(), 0);
		assertEquals(ss3.getScore(), 9);
		
		
	}
	public void testTwoThrows(){
		ss1=new ScoreSheet();
		ss2=new ScoreSheet();
		ss3=new ScoreSheet();
		/*
		 * ss1: X|5
		 * ss2: /|5
		 * ss3: 6|6
		 */
		ss1.addThrow(0);
		ss1.addThrow(5);
		ss1.addThrow(5);
		
		ss2.addThrow(5);
		ss2.addThrow(0);
		ss2.addThrow(5);
		ss2.addThrow(5);
		
		ss3.addThrow(4);
		ss3.addThrow(4);
		ss3.addThrow(4);
		ss3.addThrow(4);
		
		assertTrue(ss1.getFrame()==3);
		assertTrue(ss2.getFrame()==3);
		assertTrue(ss3.getFrame()==3);
		
		assertEquals(ss1.getScore(), 0);
		assertEquals(ss2.getScore(), 20);
		assertEquals(ss3.getScore(), 12);
		
		
	
	}
	
}
