package commands;

import editor.*;
import gui.start.GUI;
import logNrecord.memento.*;

/**
 * Cut Command class
 * 
 * @author Forget, Paget, Petit
 *
 */
public class Cut extends Command implements RecordableCommand,LogCommand {

	/**
	 * Constructor for a Cut command
	 * @param engine the engine
	 * @param ui the GUI
	 */
	public Cut(Engine engine, GUI ui) {
		super(engine, ui);
	}

	@Override
	public void execute() {
		engine.editorCut();
		engine.getRecorder().recordCommand(this);
		addToLog();
	}

	@Override
	public MementoCut getMemento() {
		return new MementoCut();
	}
	
	@Override
	public void addToLog() {
		engine.getLog().recordState(new MementoState(engine.getBuffer(), engine.getSelectionStart(), engine.getSelectionEnd()));
	}

	@Override
	public void executePlay(Memento mem) {
		engine.editorCut();
	}

}
