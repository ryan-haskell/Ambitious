package backend;

public class Tile 
{
	private int type, movement;
	
	public Tile()
	{
		this.type = Global.TILE_GRASS;
		this.movement = Global.MOVEMENT_LAND;
	}
	
	public Tile(int type)
	{
		this.type = type;
		this.movement = getMovement(type);
	}
	
	private int getMovement(int type) 
	{
		switch(type)
		{
		case 0: 
			return Global.MOVEMENT_SEA;
		case 1:
			return Global.MOVEMENT_LAND;
		default:
			System.out.println("Please add movement for tile type "+ type + ".");
		}
		return Global.MOVEMENT_LAND_SEA;
	}

	public boolean isLand()
	{
		return movement == Global.MOVEMENT_LAND;
	}
	
	public int getType()
	{
		return type;
	}
	
	public void setType(int type)
	{
		this.type = type;
	}
}
