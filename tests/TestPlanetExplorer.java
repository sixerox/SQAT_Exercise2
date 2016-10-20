import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_PlanetExplorerCreatePlanetXSize100() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(100, 50, "");
		int value = testExplorer.getX();
		assertEquals(100, value);
	}
	
	@Test
	public void test_PlanetExplorerCreatePlanetYSize50() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(100, 50, "");
		int value = testExplorer.getY();
		assertEquals(50, value);
	}
	
	@Test(expected=PlanetExplorerException.class)
	public void test_PlanetExplorerCreatePlanetInvalidXValue() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(-20, 50, "");
	}
	
	@Test
	public void test_PlanetExplorerCreatePlanetInvalidYValue() throws PlanetExplorerException {
		PlanetExplorer testExplorer = new PlanetExplorer(100, -20, "");
	}
}
