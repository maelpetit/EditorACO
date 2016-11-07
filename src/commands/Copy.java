package commands;

import editor.*;
import gui.start.EditorACOGUI;
import logNrecord.RecorderImpl;
import logNrecord.memento.*;

public class Copy extends RecordCommand implements RecordableCommand {

	public Copy(Engine engine, EditorACOGUI ui, RecorderImpl rec) {
		super(engine, ui, rec);
	}

	@Override
	public void execute() {
		engine.editorCopy();
		record.recordCommand(this);
		gui.updateClipboard();
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
