import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class FrontLineTest {

	@Test 
	public void FrontLineSimple() {
		char[][] area = new char[][] {{'R'}};
		FrontLine fl = new FrontLine(area);
		assertEquals(0, fl.getFrontLineLength());
		assertEquals(4, fl.getPerimeterR());
		assertEquals(0, fl.getPerimeterF());
	}
	
	@Test 
	public void FrontLineSize2() {
		char[][] area = new char[][] {{'R', 'F'}};
		FrontLine fl = new FrontLine(area);
		assertEquals(1, fl.getFrontLineLength());
		assertEquals(4, fl.getPerimeterR());
		assertEquals(4, fl.getPerimeterF());
	}
	
	@Test 
	public void FrontLineSize4() {
		char[][] area = new char[][] 
				{{'R', 'R'},
				 {'R', 'F'}};
		FrontLine fl = new FrontLine(area);
		assertEquals(2, fl.getFrontLineLength());
		assertEquals(8, fl.getPerimeterR());
		assertEquals(4, fl.getPerimeterF());
	}
	
	@Test 
	public void FrontLineSpiral() {
		char[][] area = new char[][] 
				{{'R','R','R','R','R','R'},
				 {'F','F','F','F','F','R'},
				 {'R','R','R','R','F','R'},
				 {'R','F','F','R','F','R'},
				 {'R','F','R','R','F','R'},
				 {'R','F','F','F','F','R'},
				 {'R','R','R','R','R','R'}};
		FrontLine fl = new FrontLine(area);
		assertEquals(31, fl.getFrontLineLength());
		assertEquals(56, fl.getPerimeterR());
		assertEquals(32, fl.getPerimeterF());
	}	

	
	@Test 
	public void FrontLine2() {
		char[][] area = new char[][] 
				{{'R','R','R','R'},
				 {'R','F','F','R'},
				 {'R','R','R','R'}};
		FrontLine fl = new FrontLine(area);
		assertEquals(6, fl.getFrontLineLength());
		assertEquals(20, fl.getPerimeterR());
		assertEquals(6, fl.getPerimeterF());
	}	
}
