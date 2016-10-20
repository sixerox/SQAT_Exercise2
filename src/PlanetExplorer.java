
// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:
// Finish time:

public class PlanetExplorer {
	
	private int planetXSize;
	private int planetYSize;
	private int explorerX;
	private int explorerY;
	private char explorerFacingDirection;
	
	public PlanetExplorer(int x, int y, String obstacles) throws PlanetExplorerException {
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
		 
	 */
		if (isPlanetSizeInputInvalid(x, y)) throw new PlanetExplorerException();
		this.planetXSize = x;
		this.planetYSize = y;
		
		this.explorerX = 0;
		this.explorerY = 0;
		this.explorerFacingDirection = 'n';
	}

	private boolean isPlanetSizeInputInvalid(int x, int y) {
		if (x < 1 || y < 1) return true;
		return false;
	}
	
	public String executeCommand(String command){
		
		this.explorerFacingDirection = 'l';
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		
		return null;
	}

	public int getPlanetXSize() {
		// TODO Auto-generated method stub
		return this.planetXSize;
	}

	public int getPlanetYSize() {
		// TODO Auto-generated method stub
		return this.planetYSize;
	}

	public int getExplorerX() {
		// TODO Auto-generated method stub
		return this.explorerX;
	}

	public int getExplorerY() {
		// TODO Auto-generated method stub
		return this.explorerY;
	}

	public char getExplorerFacingDirection() {
		// TODO Auto-generated method stub
		return this.explorerFacingDirection;
	}
}
