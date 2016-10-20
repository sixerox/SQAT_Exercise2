import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class PlanetExplorerException extends Exception {

	@Test
	public void test_createPlanetWithOutObstaclesSize100x100() {
		PlanetExplorer testExplorer = new PlanetExplorer(100, 100, "");
		int x = testExplorer.getX();
		assertEquals(100, x);
	}
}
