package backend;

public interface Display 
{
	public void drawTile(int x, int y, int color);
	public void updateScreen();
	public void slide(int direction);
}
