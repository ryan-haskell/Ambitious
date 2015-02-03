package frontend;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import backend.Input;

public class Keyboard implements KeyListener, Input
{
	boolean up, down, left, right;
	
	public Keyboard()
	{
		up = false;
		down = false;
		left = false;
		right = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) 
	{}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int keycode = e.getKeyCode();
		
		switch(keycode)
		{
		case KeyEvent.VK_W:
			up = true; break;
		case KeyEvent.VK_A:
			left = true; break;
		case KeyEvent.VK_S:
			down = true; break;
		case KeyEvent.VK_D:
			right = true; break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		int keycode = e.getKeyCode();
		
		switch(keycode)
		{
		case KeyEvent.VK_W:
			up = false; break;
		case KeyEvent.VK_A:
			left = false; break;
		case KeyEvent.VK_S:
			down = false; break;
		case KeyEvent.VK_D:
			right = false; break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0);return;
		}
	}

	public boolean getUp() {
		return up;
	}

	public boolean getDown() {
		return down;
	}

	public boolean getLeft() {
		return left;
	}

	public boolean getRight() {
		return right;
	}
	
}
