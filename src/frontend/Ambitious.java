package frontend;

import backend.Game;

public class Ambitious 
{
	public static void main(String args[])
	{
		Keyboard kb = new Keyboard();
		Frame frame = new Frame(kb);
		Game game = new Game(frame);
		kb.setGame(game);
		game.start();
	}
}
