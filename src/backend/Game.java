package backend;

public class Game
{
	private Display display;
	private Input input;
	
	private boolean moving;
	private boolean playing;
	
	private Player player;
	private World world;
	
	public Game(Display d, Input input)
	{
		this.display = d;
		this.input = input;
		this.moving = false;
		this.playing = true;
		this.player = new Player();
		this.world = new World(this);
	}

	public void start()
	{
		for(int x = 0; x < Global.RENDER_WIDTH; x++)
			for(int y = 0; y < Global.RENDER_HEIGHT; y++)
			{
				display.drawTile(x, y, world.getTileType(x-1,y-1));
			}
		
		display.updateScreen();
		
		while(playing)
		{
			//	INPUT
			boolean[] moveKeys = input.getMoveKeys();
			
			//	LOGIC
			for(int i = 0; i < Global.NUM_DIRS; i++)
			{
				if(moveKeys[i])
				{
					move(i);
					break;
				}
			}
			
			//	OUTPUT
		}
	}
	
	
	public void move(int direction)
	{		
		if(!moving)
		{
			moving = true;
			
			if(world.canMove(player, direction))
			{
				// Update player position
				player.move(direction);
				
				// Slide display in direction
				display.slide(direction);
			}
			else moving = false;
		}
	}
	
	private int getRenderX(){return player.getX()-(Global.RENDER_WIDTH/2);}
	private int getRenderY(){return player.getY()-(Global.RENDER_HEIGHT/2);}
	
	
	public void doneMoving(int direction)
	{
		//	Fill invalid row or column
		drawTiles(direction);
		
		//	Accept player move again
		moving = false;
	}
	
	private void drawTiles(int direction)
	{
		switch(direction)
		{
		case Global.DIR_UP:
			for(int x = 0; x < Global.RENDER_WIDTH; x++)
				display.drawTile(x, 0, 
						world.getTileType(getRenderX()+x, getRenderY()));
			break;
		case Global.DIR_LEFT:
			for(int y = 0; y < Global.RENDER_HEIGHT; y++)
				display.drawTile(0, y, 
						world.getTileType(getRenderX(), getRenderY()+y));
			break;
		case Global.DIR_RIGHT:
			for(int y = 0; y < Global.RENDER_HEIGHT; y++)
				display.drawTile(Global.RENDER_WIDTH-1, y, 
						world.getTileType(getRenderX()+Global.RENDER_WIDTH-1, getRenderY()+y));
			break;
		case Global.DIR_DOWN:
			for(int x = 0; x < Global.RENDER_WIDTH; x++)
				display.drawTile(x, Global.RENDER_HEIGHT-1, 
						world.getTileType(getRenderX()+x, getRenderY()+Global.RENDER_HEIGHT-1));
			break;
		}
		
		display.updateScreen();
	}
}
