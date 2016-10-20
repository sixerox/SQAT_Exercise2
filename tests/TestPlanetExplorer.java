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
	public void test_ExecuteCommandEmptyCommandReturnToStart() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		testExplorer.executeCommand("");
		assertEquals(true, checkExplorerStatus(0, 0, 'n', testExplorer.getExplorerX(), testExplorer.getExplorerY(), testExplorer.getExplorerFacingDirection()));
	}
	
	@Test
	public void test_ExecuteCommandTurnLeftOnceFromStart() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		testExplorer.executeCommand("l");
		char value = testExplorer.getExplorerFacingDirection();
		assertEquals('w', value);
	}
	
	@Test
	public void test_ExecuteCommandTurnRightOnceFromStart() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		testExplorer.executeCommand("r");
		char value = testExplorer.getExplorerFacingDirection();
		assertEquals('e', value);
	}
	
	@Test
	public void test_ExecuteCommandTurnRightTwiceFromStart() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		testExplorer.executeCommand("rr");
		char value = testExplorer.getExplorerFacingDirection();
		assertEquals('s', value);
	}
	
	@Test
	public void test_ExecuteCommandTurnLeftTwiceFromStart() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		testExplorer.executeCommand("ll");
		char value = testExplorer.getExplorerFacingDirection();
		assertEquals('s', value);
	}
	
	@Test
	public void test_ExecuteCommandTurnLeftAndRightOnce() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		testExplorer.executeCommand("lr");
		char value = testExplorer.getExplorerFacingDirection();
		assertEquals('n', value);
	}
	
	@Test
	public void test_ExecuteCommandReturnValueStartingPosition() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		String value = testExplorer.executeCommand("");
		assertEquals("(0,0,N)", value);
	}
	
	@Test
	public void test_ExecuteCommandReturnValueAfterDirectionChange() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		String value = testExplorer.executeCommand("r");
		assertEquals("(0,0,E)", value);
	}
	
	@Test
	public void test_ExecuteCommandMoveForwardOnceFacingNorth() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		String value = testExplorer.executeCommand("f");
		assertEquals("(0,1,N)", value);
	}
	
	@Test
	public void test_ExecuteCommandMoveForwardOnceFacingEast() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		String value = testExplorer.executeCommand("rf");
		assertEquals("(1,0,E)", value);
	}
	
	@Test
	public void test_ExecuteCommandMoveForwardOnceFacingNorthTurnRightMoveForwardTwice() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		String value = testExplorer.executeCommand("frff");
		assertEquals("(2,1,E)", value);
	}
	
	@Test
	public void test_ExecuteCommandMoveBackwardsOnceFacingNorth() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		String value = testExplorer.executeCommand("fb");
		assertEquals("(0,0,N)", value);
	}
	
	@Test
	public void test_ExecuteCommandOutOfBoundsMoveBackwardsFacingNorth() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		String value = testExplorer.executeCommand("b");
		assertEquals("(0,50,N)", value);
	}
	
	@Test
	public void test_ExecuteCommandOutOfBoundsMoveForwardsFacingSouth() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		String value = testExplorer.executeCommand("llf");
		assertEquals("(0,50,S)", value);
	}
	
	@Test
	public void test_ExecuteCommandOutOfBoundsMoveForwardsFacingWest() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "");
		String value = testExplorer.executeCommand("lf");
		assertEquals("(50,0,W)", value);
	}
	
	@Test
	public void test_ExecuteCommandLocateSingleObstacle() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(50, 50, "(0,1)");
		String value = testExplorer.executeCommand("f");
		assertEquals("(0,0,N)(0,1)", value); //not done yet
	}
	
	private boolean checkExplorerStatus(int expectedX, int expectedY, char expectedDir, int actualX, int actualY, char actualDir) {
		//return true if explorer at expected position
		if (expectedDir != actualDir) return false;
		if (expectedX != actualX) return false;
		if (expectedY != actualY) return false;
		return true;
	}
}
