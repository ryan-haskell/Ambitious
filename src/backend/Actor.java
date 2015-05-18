package backend;

public class Actor 
{
	protected int x, y, dir, movement;
	
	public Actor()
	{
		this.x = 0;
		this.y = 0;
		this.dir = Global.DIR_DOWN;
		this.movement = Global.MOVEMENT_LAND;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getDirection()
	{
		return dir;
	}
	
	public void move(int direction)
	{
		switch(direction)
		{
		case Global.DIR_UP:
			y = (y-1 + Global.WORLD_HEIGHT) % Global.WORLD_HEIGHT;
		case Global.DIR_LEFT:
			x = (x-1 + Global.WORLD_WIDTH) % Global.WORLD_WIDTH;
		case Global.DIR_RIGHT:
			x = (x+1)%Global.WORLD_WIDTH;
		case Global.DIR_DOWN:
			y = (y+1)%Global.WORLD_HEIGHT;
		}
		
		dir = direction;
	}
}
