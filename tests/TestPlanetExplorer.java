import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_PlanetExplorerCreatePlanetXSize100() {
		fail("Not yet implemented");
		PlanetExplorer testExplorer = new PlanetExplorer(100, 50, "");
		int value = testExplorer.getX();
		assertEquals(100, value);
	}
}
