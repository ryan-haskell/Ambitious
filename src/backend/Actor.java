package backend;

public class Actor 
{
	private int x, y, angle;
	
	public Actor(int x, int y)
	{
		setX(x);
		setY(y);
		setAngle(0);
	}
	
	public void setX(int x)
	{
		double angle = 0;
		int x2 = (int)(x*Math.cos(angle)-y*Math.sin(angle));
		int y2 = (int)(x*Math.sin(angle)+y*Math.cos(angle));
		
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setAngle(int angle)
	{
		this.angle = angle;
	}
	
	public int getX(){return x;}
	public int getY(){return y;}
	public int getAngle(){return angle;}
	
	
	
}
