package frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import backend.Display;
import backend.Global;


public class Frame extends JFrame implements Display
{
	private static final int		SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width,
									SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	private static final String		FRAME_TITLE = "Ambitious";
	private static final boolean	FRAME_RESIZABLE = false;
	private static final int 		FRAME_WIDTH = 800,
									FRAME_HEIGHT = 450,
									FRAME_X = (SCREEN_WIDTH-FRAME_WIDTH)/2,
									FRAME_Y = (SCREEN_HEIGHT-FRAME_HEIGHT)/2;

	private BufferedImage			image;
	private Graphics				graphics;
	private static int				TILE_SIZE;

	private Keyboard 				keyboard;
	
	private static final Color[] 	colors = {	new Color(0x66,0x99,0xFF),
												new Color(0x66,0xFF,0x99) };
	
	
	public Frame(Keyboard kb)
	{
		this.keyboard = kb;
		initFrame();
		initGraphics();
	}
	
	private void initFrame()
	{
		this.setTitle(FRAME_TITLE);
		this.setResizable(FRAME_RESIZABLE);
		this.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
		System.out.println(this.getSize().toString());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(keyboard);
		this.setVisible(true);
		System.out.println(this.getSize().toString());
		int vInsets = this.getInsets().top + this.getInsets().bottom;
		int hInsets = this.getInsets().left + this.getInsets().right;
		this.setSize(FRAME_WIDTH+hInsets, FRAME_HEIGHT+vInsets);
		this.repaint();
		System.out.println(this.getSize().toString());
	}
	
	private void initGraphics()
	{
		image = new BufferedImage(FRAME_WIDTH, FRAME_HEIGHT,BufferedImage.TYPE_INT_ARGB);
		graphics = image.getGraphics();
		
		int numTilesAcross = FRAME_WIDTH/Global.VIEW_WIDTH;
		int numTilesDown = FRAME_HEIGHT/Global.VIEW_HEIGHT;
		
		TILE_SIZE = Math.min(numTilesAcross, numTilesDown);
	}
	
	public void paint(Graphics g)
	{
		if(image == null) return;
		
		g.setColor(Color.WHITE);
		g.fillRect(this.getInsets().left, this.getInsets().top, FRAME_WIDTH, FRAME_HEIGHT);
		g.drawImage(image, this.getInsets().left, this.getInsets().top, null);
	}
	
	
	public void drawTile(int x, int y, int color)
	{
		graphics.setColor(colors[color]);
		graphics.fillRect(x*TILE_SIZE, y*TILE_SIZE, TILE_SIZE, TILE_SIZE);
	}
	
	public void updateScreen()
	{
		this.repaint();
	}

	public void slide(int direction) 
	{
		
	}
}
