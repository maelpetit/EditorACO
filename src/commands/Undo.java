package commands;

import editor.Engine;
import gui.start.GUI;

/**
 * Undo Command class
 * 
 * @author Forget, Paget, Petit
 *
 */
public class Undo extends Command implements CommandInterface {

	/**
	 * Constructor for a Undo command
	 * @param eng the engine
	 * @param ui the GUI
	 */
	public Undo(Engine eng, GUI ui) {
		super(eng, ui);
	}

	@Override
	public void execute() {
		if(engine.undoAvailable()){
			engine.editorUndo();
		}else
			System.err.println("Undo Unavailable");
	}

}
