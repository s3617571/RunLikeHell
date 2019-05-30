import java.util.ArrayList;

/*  This class encapsulates player position and direction
 */
public class Player extends Moveable {
	private boolean readyToStart = false;
	private int presses = 0, energy = 200;
	private int trapPut = 0;
	private int roadblockPut = 0;
	private ArrayList<Trap> traps = new ArrayList<Trap>();
	private Roadblock[] roadblocks = new Roadblock[3];

	public Player(Grid g, int row, int col) throws Exception {
		super(g);
		currentCell = grid.getCell(row, col);
		currentDirection = ' ';
	}

	public Cell move(int presses) {
		currentCell = grid.getCell(currentCell, currentDirection, presses);
		if (presses == 1) {
			energy -= 2;
		} else if (presses == 2) {
			energy -= 6;
		} else if (presses == 3) {
			energy -= 14;
		}
		return currentCell;
	}

	public int getPresses() {
		return presses;
	}

	public int getEnergy() {
		return energy;
	}

	public void addPress() {
		if (presses < 3) {
			presses += 1;
		}
	}
	
	public void clearPress() {
		presses = 0;
	}

	public void putTrap() {
		energy -= 50;
		trapPut += 1;
	}

	public void putBlock() {
		roadblockPut += 1;
	}

	public int maxCellsPerMove() {
		return 1;
	}

	public int pointsRemaining() {
		return -1; // not implemented
	}

	public void setReady(boolean val) {
		readyToStart = val;
	}

	public boolean isReady() {
		return readyToStart;
	}
}
