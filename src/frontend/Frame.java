package frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;

import backend.Display;
import backend.Game;
import backend.Global;


public class Frame extends JFrame implements Display, ActionListener
{
	private static final int		SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width,
									SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	private static final String		FRAME_TITLE = "Ambitious";
	private static final boolean	FRAME_RESIZABLE = false;
	private static final int 		FRAME_WIDTH = 800,
									FRAME_HEIGHT = 450,
									FRAME_X = (SCREEN_WIDTH-FRAME_WIDTH)/2,
									FRAME_Y = (SCREEN_HEIGHT-FRAME_HEIGHT)/2;

	private static final int 		TIMER_DELAY = 2;
	private static final int 		ANIMATION_FRAMES = 25;

	private BufferedImage			image;
	private Graphics				graphics;
	public static int				TILE_SIZE;

	private Keyboard 				keyboard;
	private Game					game;
	private Timer					slideTimer;

	private int 					slideDirection;

	private int numSlides;

	private BufferedImage original;
	
	public void setGame(Game g)
	{
		this.game = g;
	}
	
	public Frame(Keyboard kb)
	{
		this.keyboard = kb;
		initFrame();
		initTimer();
		initGraphics();
	}
	
	private void initFrame()
	{
		this.setTitle(FRAME_TITLE);
		this.setResizable(FRAME_RESIZABLE);
		this.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(keyboard);
		this.setVisible(true);
		int vInsets = this.getInsets().top + this.getInsets().bottom;
		int hInsets = this.getInsets().left + this.getInsets().right;
		this.setSize(FRAME_WIDTH+hInsets, FRAME_HEIGHT+vInsets);
		this.repaint();
	}
	
	private void initTimer()
	{
		slideTimer = new Timer(TIMER_DELAY, this);
	}
	
	private void initGraphics()
	{
		int numTilesAcross = FRAME_WIDTH/Global.VIEW_WIDTH;
		int numTilesDown = FRAME_HEIGHT/Global.VIEW_HEIGHT;
		TILE_SIZE = Math.min(numTilesAcross, numTilesDown);
		
		image = new BufferedImage(TILE_SIZE*Global.RENDER_WIDTH, TILE_SIZE*Global.RENDER_HEIGHT,BufferedImage.TYPE_INT_ARGB);
		graphics = image.getGraphics();
	}
	
	public void paint(Graphics g)
	{
		if(image == null) return;
		
		BufferedImage buffer = new BufferedImage(Global.VIEW_WIDTH*TILE_SIZE,Global.VIEW_HEIGHT*TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
		
		Graphics g2 = buffer.getGraphics();
		g2.drawImage(image, this.getInsets().left-TILE_SIZE, this.getInsets().top-TILE_SIZE, null);
		g2.drawImage(this.getImage("img/player.png"), Global.VIEW_WIDTH/2*TILE_SIZE, Global.VIEW_HEIGHT/2*TILE_SIZE, null);
		
		g.drawImage(buffer, 0, 0, null);
	}
	
	
	public void drawTile(int x, int y, int type)
	{
		graphics.drawImage(getImage(type), x*TILE_SIZE, y*TILE_SIZE, null);
	}
	
	private Image getImage(int type) 
	{
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(new File("img/tiles/"+type+".png"));
			image = getScaledImage(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	private Image getImage(String file) 
	{
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(new File(file));
			image = getScaledImage(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	private BufferedImage getScaledImage(BufferedImage src)
	{
	    int finalh = TILE_SIZE, finalw = TILE_SIZE;
	    BufferedImage resizedImg = new BufferedImage(finalw, finalh, BufferedImage.TRANSLUCENT);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
	    g2.drawImage(src, 0, 0, finalw, finalh, null);
	    g2.dispose();
	    return resizedImg;
	}
	
	public void updateScreen()
	{
		this.repaint();
	}

	public void slide(int direction) 
	{
		slideDirection = direction;
		numSlides = 0;
		original = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_ARGB);
		original.getGraphics().drawImage(image, 0, 0, null);
		slideTimer.start();
	}

	public void drawImage(BufferedImage original, int x, int y) 
	{
		graphics.drawImage(original, x, y, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{		
		numSlides++;
		
		switch(slideDirection)
		{
		case Global.DIR_UP:
			drawImage(original, 0, numSlides*(Frame.TILE_SIZE/ANIMATION_FRAMES));
			break;
		case Global.DIR_LEFT:
			drawImage(original, numSlides*(Frame.TILE_SIZE/ANIMATION_FRAMES), 0);
			break;
		case Global.DIR_RIGHT:
			drawImage(original, -numSlides*(Frame.TILE_SIZE/ANIMATION_FRAMES), 0);
			break;
		case Global.DIR_DOWN:
			drawImage(original, 0, -numSlides*(Frame.TILE_SIZE/ANIMATION_FRAMES));
			break;
		}

		updateScreen();
		if(numSlides >= ANIMATION_FRAMES)
		{
			numSlides = 0;
			slideTimer.stop();
			game.doneMoving(slideDirection);
		}
	}
}
