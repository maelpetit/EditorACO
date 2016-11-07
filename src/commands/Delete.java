package commands;

import editor.*;
import gui.start.EditorACOGUI;
import logNrecord.RecorderImpl;
import logNrecord.memento.*;

public class Delete extends RecordCommand implements RecordableCommand,LogCommand {

	public Delete(Engine engine, EditorACOGUI ui, RecorderImpl rec) {
		super(engine, ui, rec);
	}

	@Override
	public void execute() {
		engine.editorInsert("");
		record.recordCommand(this);
		addToLog();
		if(!engine.redoAvailable()){
			gui.disableRedoButton();
		}
		gui.updateBuffer();
		gui.updateSelection();
		gui.highlight(engine.getSelectionStart(), engine.getSelectionEnd());
	}

	@Override
	public MementoDelete getMemento() {
		return new MementoDelete();
	}
	
	@Override
	public void addToLog() {
		engine.getLog().recordState(new MementoState(engine.getBuffer(), engine.getSelectionStart(), engine.getSelectionEnd()));
		gui.enableUndoButton();
	}

	@Override
	public void executePlay(Memento mem) {
		engine.editorInsert("");
	}

}
