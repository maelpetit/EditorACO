package commands;

import editor.*;
import gui.start.GUI;
import logNrecord.memento.Memento;
import logNrecord.memento.MementoPaste;
import logNrecord.memento.MementoState;

/**
 * Paste Command class
 * 
 * @author Forget, Paget, Petit
 *
 */
public class Paste extends Command implements RecordableCommand,LogCommand {

	/**
	 * Constructor for a Paste command
	 * @param engine the engine
	 * @param ui the GUI
	 */
	public Paste(Engine engine, GUI ui) {
		super(engine, ui);
	}

	@Override
	public void execute() {
		if(engine.getClipboard().isEmpty())
			System.err.println("DEBUG: Nothing to paste");
		else{
			engine.editorPaste();
			engine.getRecorder().recordCommand(this);
			addToLog();
		}
	}

	@Override
	public MementoPaste getMemento() {
		return new MementoPaste();
	}

	@Override
	public void addToLog() {
		engine.getLog().recordState(new MementoState(engine.getBuffer(), engine.getSelectionStart(), engine.getSelectionEnd()));
	}
 
	@Override
	public void executePlay(Memento mem) {
		engine.editorPaste();
	}
}
