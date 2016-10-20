import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_PlanetExplorerCreatePlanetXSize100() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(100, 50, "");
		int value = testExplorer.getPlanetXSize();
		assertEquals(100, value);
	}
	
	@Test
	public void test_PlanetExplorerCreatePlanetYSize50() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(100, 50, "");
		int value = testExplorer.getPlanetYSize();
		assertEquals(50, value);
	}
	
	@Test(expected=PlanetExplorerException.class)
	public void test_PlanetExplorerCreatePlanetInvalidXValue() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(-20, 50, "");
	}
	
	@Test(expected=PlanetExplorerException.class)
	public void test_PlanetExplorerCreatePlanetInvalidYValue() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(100, -20, "");
	}
	
	@Test
	public void test_PlanetExplorerXLocationAtStart() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		int value = testExplorer.getExplorerX();
		assertEquals(0, value);
	}
	
	@Test
	public void test_PlanetExplorerYLocationAtStart() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		int value = testExplorer.getExplorerY();
		assertEquals(0, value);
	}
	
	@Test
	public void test_PlanetExplorerFacingDirectionAtStart() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		char value = testExplorer.getExplorerFacingDirection();
		assertEquals('n', value);
	}
	
	@Test
	public void test_PlanetExplorerEmptyCommandReturnToStart() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		testExplorer.executeCommand("");
		assertEquals(true, checkExplorerStatus(0, 0, 'n', testExplorer.getExplorerX(), testExplorer.getExplorerY(), testExplorer.getExplorerFacingDirection()));
	}
	
	@Test
	public void test_PlanetExplorerTurnLeftOnceFromStart() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		testExplorer.executeCommand("l");
		char value = testExplorer.getExplorerFacingDirection();
		assertEquals('w', value);
	}
	
	@Test
	public void test_PlanetExplorerTurnRightOnceFromStart() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		testExplorer.executeCommand("r");
		char value = testExplorer.getExplorerFacingDirection();
		assertEquals('e', value);
	}
	
	@Test
	public void test_PlanetExplorerTurnRightTwiceFromStart() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		testExplorer.executeCommand("rr");
		char value = testExplorer.getExplorerFacingDirection();
		assertEquals('s', value);
	}
	
	private boolean checkExplorerStatus(int expectedX, int expectedY, char expectedDir, int actualX, int actualY, char actualDir) {
		//return true if explorer at expected position
		if (expectedDir != actualDir) return false;
		if (expectedX != actualX) return false;
		if (expectedY != actualY) return false;
		return true;
	}
}
