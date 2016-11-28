package commands;

import editor.*;
import gui.start.GUI;
import logNrecord.memento.Memento;
import logNrecord.memento.MementoPaste;
import logNrecord.memento.MementoState;

public class Paste extends RecordCommand implements RecordableCommand,LogCommand {

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
