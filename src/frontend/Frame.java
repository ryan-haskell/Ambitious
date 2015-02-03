package frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import backend.Clock;
import backend.Display;
import backend.Game;
import backend.Global;

public class Frame extends JFrame implements Display, Clock
{
	
	//	COLORS
	private Color[] colors = new Color[]{Color.BLUE, Color.GREEN, Color.BLACK};
		
	//	INPUT
	private Keyboard keyboard;
	
	//	TIMER
	private boolean timerReady;
	
	//	DRAWING THINGS
	private BufferedImage image;
	private Graphics imageGraphics;
	
	
	public Frame()
	{
		initFrame();
		initImage();
		
		draw();
	}
	
	private void initFrame()
	{
		setTitle("Ambitious");
		setBounds(Global.FRAME_X, Global.FRAME_Y, Global.FRAME_W, Global.FRAME_H);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	public void setKeyboard(Keyboard k)
	{
		keyboard = k;
		this.addKeyListener(k);
	}
	
	public void draw()
	{
		this.repaint();
	}
	
	public void paint(Graphics g)
	{
		if(image == null)
		{
			initImage();
		}
		
		g.drawImage(image,0,0, null);
	}
	
	private void initImage()
	{
		image = new BufferedImage(Global.FRAME_W, Global.FRAME_H, BufferedImage.TYPE_INT_ARGB);
		imageGraphics = image.getGraphics();
		imageGraphics.setColor(Color.black);
		imageGraphics.fillRect(0, 0, Global.FRAME_W, Global.FRAME_H);
	}
	
	public double getCurrentTime()
	{
		return System.currentTimeMillis();
	}

	public void drawRect(int x, int y, int w, int h, int color) 
	{
		imageGraphics.setColor(colors[color]);
		imageGraphics.fillRect(x, y, w, h);
	}
}
