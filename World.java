package LangtonsAnt;

public class World {

	private final int worldSize =400;
	private int world[][] = new int[worldSize][worldSize];
	
	public int[][] getWorld() {
		return world;
	}
	
		
	public int getWorldSize() {
		return worldSize;
	}
}
