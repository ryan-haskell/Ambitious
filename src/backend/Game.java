package backend;

public class Game 
{
	private World world;
	private Ambi player;
	private Ship playerShip;
	private Display display;
	private Input input;
	private Clock clock;

	private boolean up,down,left,right;
	
	public Game()
	{
		player = new Ambi();
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
		  
		  if(elapsed > 1000/Global.FPS)
		  {
			  //	UPDATE

			  update(elapsed);
			  lastTime = current;
			  
			  //	OUTPUT
			  display.draw();
		  } 
		}
	}
	
	private void update(double elapsed)
	{
		player.move(up,left,down,right,display);
	}
}
