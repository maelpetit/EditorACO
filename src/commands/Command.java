package commands;

import editor.*;
import gui.start.GUI;

public class Command  {
	protected Engine engine;
	protected GUI gui;
	
	public Command(Engine eng, GUI GUI){
		engine = eng;
		gui = GUI;
	}

}
