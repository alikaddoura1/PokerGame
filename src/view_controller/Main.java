// Author: Ali Kaddoura
package view_controller;

import java.util.ArrayList;

import model.Game;

/**
 * This plays a console game of Arizona Hold-Em, a reduced version of Texas
 * Hold-Em
 * 
 * @author Rick Mercer & Ali Kaddoura
 */
public class Main {

	public static void main(String[] args) {

		Game game = new Game();
		game.start();
	}

}
