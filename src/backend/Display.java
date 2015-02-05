package backend;

public interface Display 
{

	public void draw();
	public void drawRect(int x, int y, int w, int h, int color);
	public void drawPolygon(int[] xs, int[] ys, int size, int color);

}
