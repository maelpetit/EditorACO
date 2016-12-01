package commands;

import editor.*;
import gui.start.GUI;
import logNrecord.memento.*;

/**
 * Delete Command class
 * 
 * @author Forget, Paget, Petit
 *
 */
public class Delete extends Command implements RecordableCommand,LogCommand {

	/**
	 * Constructor for a Delete command
	 * @param engine the engine
	 * @param ui the GUI
	 */
	public Delete(Engine engine, GUI ui) {
		super(engine, ui);
	}

	@Override
	public void execute() {
		engine.editorInsert("");
		engine.getRecorder().recordCommand(this);
		addToLog();
	}

	@Override
	public MementoDelete getMemento() {
		return new MementoDelete();
	}
	
	@Override
	public void addToLog() {
		engine.getLog().recordState(new MementoState(engine.getBuffer(), engine.getSelectionStart(), engine.getSelectionEnd()));
	}

	@Override
	public void executePlay(Memento mem) {
		engine.editorInsert("");
	}

}
