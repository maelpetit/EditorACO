package commands;

import editor.*;
import gui.start.EditorACOGUI;
import logNrecord.MementoState;
import logNrecord.RecorderImpl;

public class Paste extends RecordCommand implements RecordableCommandInterface {

	public Paste(Engine engine, EditorACOGUI ui, RecorderImpl rec) {
		super(engine, ui, rec);
	}

	@Override
	public void execute() {
		engine.editorPaste();
		record.recordCommand(this);
		addToLog();
		if(!engine.redoAvailable()){
			gui.disableRedoButton();
		}
	}

	@Override
	public MementoState getMemento() {
		return new MementoState();
	}

	@Override
	public void addToLog() {
		engine.getLog().recordState(new MementoState(engine.getBuffer(), engine.getSelectionStart(), engine.getSelectionEnd()));
		gui.enableUndoButton();
	}

	@Override
	public void executePlay(MementoState mem) {
		engine.editorPaste();
	}
}
