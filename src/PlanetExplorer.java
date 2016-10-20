import java.util.ArrayList;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:
// Finish time:

public class PlanetExplorer {
	
	private static final char NORTH = 'n';
	private static final char EAST = 'e';
	private static final char SOUTH = 's';
	private static final char WEST = 'w';
	private static final char FORWARDS = 'f';
	private static final char BACKWARDS = 'b';
	private int planetXSize;
	private int planetYSize;
	private int explorerX;
	private int explorerY;
	private Character explorerFacingDirection;
	private ArrayList<int[]> obstacleList;
	private ArrayList<int[]> locatedObstacleList;
	
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
		this.explorerFacingDirection = NORTH;
		obstacleList = new ArrayList<int[]>();
		locatedObstacleList = new ArrayList<int[]>();
		
		if (!obstacles.equals("")) {
			parseObstacles(obstacles);
		}
	}

	private void parseObstacles(String obstacleString) throws PlanetExplorerException {
		String[] obstacles = obstacleString.split("\\)");
		
		for (int i = 0; i < obstacles.length; i++) {
			parseSingleObstacle(obstacles[i]);
		}
	}

	private void parseSingleObstacle(String obstacleString) throws PlanetExplorerException {
		//remove '('
		obstacleString = obstacleString.substring(1);
		
		String[] coordinates = obstacleString.split(",");
		try {
			int x = Integer.parseInt(coordinates[0]);
			int y = Integer.parseInt(coordinates[1]);
			int[] intCoordinates = {x,y};
			obstacleList.add(intCoordinates);
		} catch (Exception e) {
			throw new PlanetExplorerException();
		}
		
	}

	private boolean isPlanetSizeInputInvalid(int x, int y) {
		if (x < 1 || y < 1) return true;
		return false;
	}
	
	public String executeCommand(String command) throws PlanetExplorerException{
			
		for (int i = 0; i < command.length(); i++) {
			char currentCommand = command.charAt(i);
			
			if (currentCommand == 'l' || currentCommand == 'r') {
				rotateExplorer(currentCommand);
			}
			
			if (currentCommand == FORWARDS || currentCommand == BACKWARDS) {
				moveExplorer(currentCommand);
			}
			
			
		}
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		String returnString = "(" + this.explorerX + "," + this.explorerY + "," + Character.toUpperCase(this.explorerFacingDirection) + ")";
		
		//Obstacle print not done
		for (int[] obstacle: locatedObstacleList) {
			
		}
		
		return returnString;
	}

	private void moveExplorer(char currentCommand) throws PlanetExplorerException {
		
		if (currentCommand == FORWARDS && this.explorerFacingDirection == NORTH) {
			if (this.planetYSize == this.explorerY) {
				if (doesPositionContainObstacle(this.explorerX, 0)) {
					foundNewObstacle(this.explorerX,0);
					return;
				}
				else {
					this.explorerY = 0;
					return;
				}
			}
			
			if (doesPositionContainObstacle(this.explorerX, this.explorerY + 1)) {
				foundNewObstacle(this.explorerX, this.explorerY + 1);
				return;
			}
			else {
				this.explorerY++;
				return;
			}
		}
		if (currentCommand == FORWARDS && this.explorerFacingDirection == EAST) {
			if (this.planetXSize == this.explorerX) {
				this.explorerX = 0;
				return;
			}
			this.explorerX++;
			return;
		}
		if (currentCommand == FORWARDS && this.explorerFacingDirection == SOUTH) {
			if (this.explorerY == 0) {
				this.explorerY = this.planetYSize;
				return;
			}
			this.explorerY--;
			return;
		}
		if (currentCommand == FORWARDS && this.explorerFacingDirection == WEST) {
			if (this.explorerX == 0) {
				this.explorerX = this.planetXSize;
				return;
			}
			this.explorerX--;
			return;
		}
		
		if (currentCommand == BACKWARDS && this.explorerFacingDirection == NORTH) {
			if (this.explorerY == 0) {
				this.explorerY = this.planetYSize;
				return;
			}
			this.explorerY--;
			return;
		}
		if (currentCommand == BACKWARDS && this.explorerFacingDirection == EAST) {
			if (this.explorerX == 0) {
				this.explorerX = this.planetXSize;
				return;
			}
			this.explorerX--;
			return;
		}
		if (currentCommand == BACKWARDS && this.explorerFacingDirection == SOUTH) {
			if (this.planetYSize == this.explorerY) {
				this.explorerY = 0;
				return;
			}
			this.explorerY++;
			return;
		}
		if (currentCommand == BACKWARDS && this.explorerFacingDirection == WEST) {
			if (this.planetXSize == this.explorerX) {
				this.explorerX = 0;
			}
			this.explorerX++;
			return;
		}
		
	}

	private void foundNewObstacle(int x, int y) {
		locatedObstacleList.add(new int[]{x,y});	
	}

	private void rotateExplorer(char currentCommand) {
		
		if (currentCommand == 'l' && this.explorerFacingDirection == NORTH) {
			this.explorerFacingDirection = WEST;
			return;
		}
		if (currentCommand == 'l' && this.explorerFacingDirection == EAST) {
			this.explorerFacingDirection = NORTH;
			return;
		}
		if (currentCommand == 'l' && this.explorerFacingDirection == SOUTH) {
			this.explorerFacingDirection = EAST;
			return;
		}
		if (currentCommand == 'l' && this.explorerFacingDirection == WEST) {
			this.explorerFacingDirection = SOUTH;
			return;
		}
		
		if (currentCommand == 'r' && this.explorerFacingDirection == NORTH) {
			this.explorerFacingDirection = EAST;
			return;
		}
		if (currentCommand == 'r' && this.explorerFacingDirection == EAST) {
			this.explorerFacingDirection = SOUTH;
			return;
		}
		if (currentCommand == 'r' && this.explorerFacingDirection == SOUTH) {
			this.explorerFacingDirection = WEST;
			return;
		}
		if (currentCommand == 'r' && this.explorerFacingDirection == WEST) {
			this.explorerFacingDirection = NORTH;
			return;
		}
		
	}
	
	private boolean doesPositionContainObstacle(int x, int y) {
		return false;
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
