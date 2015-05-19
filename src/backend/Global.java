package backend;

public class Global 
{
	public static final int 	VIEW_WIDTH = 16,
								VIEW_HEIGHT = 9,
								RENDER_WIDTH = VIEW_WIDTH+2,
								RENDER_HEIGHT = VIEW_HEIGHT+2,
								WORLD_WIDTH = 16,
								WORLD_HEIGHT = 8;
	
	public static final int		TILE_WATER = 0,
								TILE_GRASS = 1;
	
	public static final int 	DIR_UP = 0,
								DIR_LEFT = 1,
								DIR_RIGHT = 2,
								DIR_DOWN = 3;
	public static final String[] directions = {"UP", "LEFT", "RIGHT", "DOWN"};
	public static final int 	NUM_DIRS = 4;
	
	public static final int 	MOVEMENT_LAND = 0,
								MOVEMENT_SEA = 1,
								MOVEMENT_LAND_SEA = 2;


								
}
