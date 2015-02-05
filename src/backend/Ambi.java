package backend;

public class Ambi extends Actor
{
	private static int INIT_X = 200;
	private static int INIT_Y = 200;
	private static int INIT_ANGLE = 0;
	
	public Ambi()
	{
		super(INIT_X, INIT_Y);
	}
	
	public void move(boolean up, boolean left, boolean down, boolean right, Display display)
	{
		if(down || left || up || right)
			display.drawRect(getX(), getY(), Global.PLAYER_SIZE, Global.PLAYER_SIZE, Global.COLOR_BLACK);
		
		if(down)
		{
			setY(getY()+Global.PLAYER_SPEED);
		}
		if(up)
		{
			setY(getY()-Global.PLAYER_SPEED);		
		}
		if(right)
		{
			setX(getX()+Global.PLAYER_SPEED);
		}
		if(left)
		{
			setX(getX()-Global.PLAYER_SPEED);
		}
		
		display.drawRect(getX(), getY(), Global.PLAYER_SIZE, Global.PLAYER_SIZE, Global.COLOR_BLUE);
	}
}
