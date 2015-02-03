package backend;

import java.awt.Toolkit;

public class Global 
{
	//	SCREEN AND FRAME
	public static final int 	SCREEN_W = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
								SCREEN_H = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int		FRAME_W = 800, FRAME_H = 450;
	public static final int		FRAME_X = 200,
								FRAME_Y = 200;
	
	//	COLOR
	public static final int COLOR_BLUE = 0,	COLOR_GREEN = 1, COLOR_BLACK = 2;
	
	//	PLAYER
	public static final int PLAYER_SIZE = 20;
}
