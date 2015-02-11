import java.util.Comparator;
import junit.framework.TestCase;

public class TestScoreSheet extends TestCase{
//	
	private ScoreSheet ss1 = new ScoreSheet();
//	
	private ScoreSheet ss2 = new ScoreSheet();
//	
	private ScoreSheet ss3 = new ScoreSheet();
	public void testOneThrow(){
		ss1.addThrow(0);
		ss2.addThrow(5);
		ss3.addThrow(9);
		
		assertTrue(ss1.getFrame()==2);
		assertTrue(ss2.getFrame()==1);
		assertTrue(ss3.getFrame()==1);
		
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
		
	}
}
