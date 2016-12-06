package commands;

import editor.Engine;
import gui.start.GUI;

/**
 * Redo Command class
 * 
 * @author Forget, Paget, Petit
 *
 */
public class Redo extends Command implements CommandInterface {

	/**
	 * Constructor for a Redo command
	 * @param eng the engine
	 * @param ui the GUI
	 */
	public Redo(Engine eng ,GUI ui) {
		super(eng, ui);
	}

	@Override
	public void execute() {
		if(engine.redoAvailable()){
			engine.editorRedo();
		}else
			System.err.println("Redo Unavailable");
	}

}
