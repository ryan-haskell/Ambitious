package backend;

public class Game
{
	private Display display;
	private boolean moving;
	private Player player;
	private World world;
	
	public Game(Display d)
	{
		this.display = d;
		this.moving = false;
		this.player = new Player();
		this.world = new World(this);
	}

	public void start()
	{
		for(int x = 0; x < Global.WORLD_WIDTH; x++)
			for(int y = 0; y < Global.WORLD_HEIGHT; y++)
			{
				display.drawTile(x, y, (x+y+y)%2);
			}
		
		display.updateScreen();
	}
	
	
	public void move(int direction)
	{
		if(!moving)
		{
			moving = true;
			
			if(world.canMove(player, direction))
			{
				player.move(direction);
				display.slide(direction);
			}
		}
	}
	
	public void resetMoving()
	{
		moving = false;
	}
}
