package frontend;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import backend.Game;

public class Keyboard implements KeyListener
{
	private Game		game;
	
	public void setGame(Game g)
	{
		this.game = g;
	}

	@Override
	public void keyPressed(KeyEvent event) 
	{
		System.out.println("Pressed");
	}

	@Override
	public void keyReleased(KeyEvent event) 
	{
		
	}

	@Override
	public void keyTyped(KeyEvent event) 
	{
		
	}

}
