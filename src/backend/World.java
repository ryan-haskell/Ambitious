package backend;

public class World 
{
	private Game game;
	private Tile[][] tiles;
	
	public World(Game game)
	{
		this.game = game;
		initTiles();
	}
	
	public void initTiles()
	{
		tiles = new Tile[Global.WORLD_WIDTH][Global.WORLD_HEIGHT];
		
		for(int x = 0; x < Global.WORLD_WIDTH; x++)
			for(int y = 0; y < Global.WORLD_HEIGHT; y++)
			{
				tiles[x][y] = new Tile();
			}
	}
	
	public boolean canMove(Actor actor, int direction)
	{
		int x = actor.getX();
		int y = actor.getY();
		int newX = x;
		int newY = y;
		
		switch(direction)
		{
			case Global.DIR_UP:
				newY = (newY-1 + Global.WORLD_HEIGHT) % Global.WORLD_HEIGHT;
			case Global.DIR_LEFT:
				newX = (newX-1 + Global.WORLD_WIDTH) % Global.WORLD_WIDTH;
			case Global.DIR_RIGHT:
				newX = (newX+1)%Global.WORLD_WIDTH;
			case Global.DIR_DOWN:
				newY = (newY+1)%Global.WORLD_HEIGHT;
		}
		
		if(actor.movement == Global.MOVEMENT_LAND)
			return tiles[newX][newY].isLand();
		else return false;
	}
}
