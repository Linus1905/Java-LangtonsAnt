package LangtonsAnt;



public class Ant {

	private Direction direction;
	private int positionX, positionY;	
	private World world = new World();
	private final int steps = 10000;
	
	public Ant(int positionX, int positionY, Direction direction) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.direction = direction;		
	}
	
	public int getSteps() {
		return steps;
	}
	
	public int getPositionX() {
		return this.positionX;
	}
	
	public int getPositionY() {
		return this.positionY;
	}
	
	public void setDirection(Direction direction) {
	this.direction = direction;
 }

	public Direction getDirection() {
		return this.direction;
	}
	
	public boolean inWorld(Ant a) {		
		if(a.getPositionX()<=world.getWorldSize()-2 && a.getPositionY()<=world.getWorldSize()-2
				&& a.getPositionX()>=1 && a.getPositionY()>=1) {		
			return true;
		}		
		return false;
	}
	
public boolean nextStep(int w[][],Ant a) {
		
	if(inWorld(a) == true) {
	
	if(w[a.getPositionX()][a.getPositionY()]==0 && a.getDirection()==Direction.North) {
		a.setDirection(Direction.West); 
		w[a.getPositionX()][a.getPositionY()]=1; 
		a.positionY--;
	}
	
	if(w[a.getPositionX()][a.getPositionY()]==0 && a.getDirection()==Direction.East) {
		a.setDirection(Direction.North);
		w[a.getPositionX()][a.getPositionY()]=1;
		a.positionX++; 
		}
	
	if(w[a.getPositionX()][a.getPositionY()]==0 && a.getDirection()==Direction.South) {
		a.setDirection(Direction.East);
		w[a.getPositionX()][a.getPositionY()]=1;
		a.positionY++;  
		}
	
	if(w[a.getPositionX()][a.getPositionY()]==0 && a.getDirection()==Direction.West) {
		a.setDirection(Direction.South); 
		w[a.getPositionX()][a.getPositionY()]=1; 
		a.positionX--; 
		}

	if(w[a.getPositionX()][a.getPositionY()]==1 && a.getDirection()==Direction.North) {  
		a.setDirection(Direction.East);
		w[a.getPositionX()][a.getPositionY()]=0;  
		a.positionY++;  
		}
	
	if(w[a.getPositionX()][a.getPositionY()]==1 && a.getDirection()==Direction.East) {
		a.setDirection(Direction.South);
		w[a.getPositionX()][a.getPositionY()]=0; 
        a.positionX--; 
		}
	
	if(w[a.getPositionX()][a.getPositionY()]==1 && a.getDirection()==Direction.South) {
		a.setDirection(Direction.West); 
		w[a.getPositionX()][a.getPositionY()]=0;
		a.positionY--; 
		}
	
	if(w[a.getPositionX()][a.getPositionY()]==1 && a.getDirection()==Direction.West) { 
		 a.setDirection(Direction.North);
		 w[a.getPositionX()][a.getPositionY()]=0; 
		 a.positionX++; 
		}

      return true;
	}	
return false;
}

}