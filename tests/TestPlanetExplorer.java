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
}
