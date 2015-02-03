package backend;

public class Game 
{
	private World world;
	private Player player;
	private Display display;
	private Input input;
	private Clock clock;

	private boolean up,down,left,right;
	
	public Game()
	{
		player = new Player();
	}
	
	private void initWorld()
	{
		world = new World();
	}
	
	public void setInput(Input i)
	{
		input = i;
	}
	
	public void setDisplay(Display d)
	{
		display = d;
	}
	
	public void setClock(Clock c)
	{
		clock = c;
	}
	
	public void start()
	{
		double lastTime = clock.getCurrentTime();
		while(true)
		{
		  double current = clock.getCurrentTime();
		  double elapsed = current - lastTime;

		  //	INPUT
		  up = input.getUp();
		  down = input.getDown();
		  left = input.getLeft();
		  right = input.getRight();
		  
		  //	UPDATE
		  if(elapsed > 1000/60)
		  {
			  update(elapsed);
			  lastTime = current;
		  } 
		  
		  //	OUTPUT
		  display.draw();
		}
	}
	
	private void update(double elapsed)
	{
		if(down || left || up || right)
			display.drawRect(player.x, player.y, Global.PLAYER_SIZE, Global.PLAYER_SIZE, Global.COLOR_BLACK);
		
		if(down)
		{
			player.y += elapsed;
		}
		else if(up)
		{
			player.y -= elapsed;
		}
		else if(right)
		{
			player.x += elapsed;
		}
		else if(left)
		{
			player.x -= elapsed;
		}
		
		display.drawRect(player.x, player.y, Global.PLAYER_SIZE, Global.PLAYER_SIZE, Global.COLOR_BLUE);
	}
}
