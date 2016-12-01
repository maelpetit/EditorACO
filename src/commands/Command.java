package commands;

import editor.*;
import gui.start.GUI;

/**
 * Standard mother commmand class
 * 
 * @author Forget, Paget, Petit
 *
 */
public class Command  {
	protected Engine engine;
	protected GUI gui;
	
	/**
	 * Constructor for mother command
	 * @param eng the engine
	 * @param GUI the GUI
	 */
	public Command(Engine eng, GUI GUI){
		engine = eng;
		gui = GUI;
	}

}
