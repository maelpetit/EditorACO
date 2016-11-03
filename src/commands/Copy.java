package commands;

import editor.*;
import gui.start.EditorACOGUI;
import logNrecord.MementoState;
import logNrecord.RecorderImpl;

public class Copy extends RecordCommand implements RecordableCommandInterface {

	public Copy(Engine engine, EditorACOGUI ui, RecorderImpl rec) {
		super(engine, ui, rec);
	}

	@Override
	public void execute() {
		engine.editorCopy();
		record.recordCommand(this);
		addToLog();
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
		engine.editorCopy();
	}

}
