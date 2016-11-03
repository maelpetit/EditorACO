package commands;

import editor.*;
import gui.start.EditorACOGUI;

public class Command  {
	protected Engine engine;
	protected EditorACOGUI gui;
	
	public Command(Engine eng, EditorACOGUI ui){
		engine = eng;
		gui = ui;
	}

}
