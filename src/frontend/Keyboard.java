package frontend;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import backend.Game;
import backend.Global;
import backend.Input;

public class Keyboard implements KeyListener, Input
{
	private boolean[]	moveKeys;

	public Keyboard()
	{
		resetMoveKeys();
	}
	
	@Override
	public void keyPressed(KeyEvent event) 
	{
		switch(event.getKeyCode())
		{
		case KeyEvent.VK_UP:
			moveKeys[Global.DIR_UP] = true;
			break;
		case KeyEvent.VK_LEFT:
			moveKeys[Global.DIR_LEFT] = true;
			break;
		case KeyEvent.VK_RIGHT:
			moveKeys[Global.DIR_RIGHT] = true;
			break;
		case KeyEvent.VK_DOWN:
			moveKeys[Global.DIR_DOWN] = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent event) 
	{
		switch(event.getKeyCode())
		{
		case KeyEvent.VK_UP:
			moveKeys[Global.DIR_UP] = false;
			break;
		case KeyEvent.VK_LEFT:
			moveKeys[Global.DIR_LEFT] = false;
			break;
		case KeyEvent.VK_RIGHT:
			moveKeys[Global.DIR_RIGHT] = false;
			break;
		case KeyEvent.VK_DOWN:
			moveKeys[Global.DIR_DOWN] = false;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent event){}
	
	public boolean[] getMoveKeys()
	{
		return moveKeys;
	}
	
	private void resetMoveKeys()
	{
		this.moveKeys = new boolean[]{false, false, false, false};
	}

}
