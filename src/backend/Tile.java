package backend;

public class Tile 
{
	private int color, movement;
	
	public Tile()
	{
		this.color = Global.COLOR_GREEN;
		this.movement = Global.MOVEMENT_LAND;
	}
	
	public Tile(int color, int movement)
	{
		this.color = color;
		this.movement = movement;
	}
	
	public boolean isLand()
	{
		return movement == Global.MOVEMENT_LAND;
	}
	
	public int getColor()
	{
		return color;
	}
}
