import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_PlanetExplorerCreatePlanetXSize100() {
		PlanetExplorer testExplorer = new PlanetExplorer(100, 50, "");
		int value = testExplorer.getX();
		assertEquals(100, value);
	}
	
	@Test
	public void test_PlanetExplorerCreatePlanetYSize50() {
		PlanetExplorer testExplorer = new PlanetExplorer(100, 50, "");
		int value = testExplorer.getY();
		assertEquals(50, value);
	}
}
