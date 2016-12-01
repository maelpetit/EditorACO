package commands;

import editor.*;
import gui.start.GUI;
import logNrecord.memento.*;

/**
 * Copy Command class
 * 
 * @author Forget, Paget, Petit
 *
 */
public class Copy extends Command implements RecordableCommand {

	/**
	 * Constructor for a Copy command
	 * @param engine the engine
	 * @param ui the GUI
	 */
	public Copy(Engine engine, GUI ui) {
		super(engine, ui);
	}

	@Override
	public void execute() {
		if(engine.getSelectionStart() == engine.getSelectionEnd())
			System.err.println("DEBUG: Nothing to copy");
		else{
			engine.editorCopy();
			engine.getRecorder().recordCommand(this);
		}
	}

	@Override
	public MementoCopy getMemento() {
		return new MementoCopy();
	}


	@Override
	public void executePlay(Memento mem) {
		engine.editorCopy();
	}

}
