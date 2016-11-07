package commands;

import editor.*;
import gui.start.EditorACOGUI;
import logNrecord.RecorderImpl;
import logNrecord.memento.Memento;
import logNrecord.memento.MementoCut;
import logNrecord.memento.MementoState;

public class Cut extends RecordCommand implements RecordableCommand,LogCommand {

	public Cut(Engine engine, EditorACOGUI ui, RecorderImpl rec) {
		super(engine, ui, rec);
	}

	@Override
	public void execute() {
		engine.editorCut();
		record.recordCommand(this);
		addToLog();
		if(!engine.redoAvailable()){
			gui.disableRedoButton();
		}
		gui.updateBuffer();
		gui.updateClipboard();
		gui.highlight(engine.getSelectionStart(), engine.getSelectionEnd());
	}

	@Override
	public MementoCut getMemento() {
		return new MementoCut();
	}
	
	@Override
	public void addToLog() {
		engine.getLog().recordState(new MementoState(engine.getBuffer(), engine.getSelectionStart(), engine.getSelectionEnd()));
		gui.enableUndoButton();
	}

	@Override
	public void executePlay(Memento mem) {
		engine.editorCut();
	}

}
