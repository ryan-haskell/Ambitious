package frontend;

import backend.Game;

public class Ambitious 
{
	public static void main(String args[])
	{
		Frame frame = new Frame();
		Keyboard kb = new Keyboard();		
		Game game = new Game();
		
		game.setDisplay(frame);
		game.setClock(frame);
		game.setInput(kb);
		
		frame.setKeyboard(kb);		
		
		game.start();
	}
}
