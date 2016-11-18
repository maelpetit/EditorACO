package commands;

import editor.Engine;
import gui.start.EditorACOGUI;
import logNrecord.memento.Memento;
import logNrecord.memento.MementoSelectAll;

public class SelectAll extends RecordCommand implements RecordableCommand {

	public SelectAll(Engine eng, EditorACOGUI ui) {
		super(eng, ui);
	}

	@Override
	public void execute() {
		int stop = engine.getBuffer().length();
		engine.editorSelect(0, stop);
		engine.getRecorder().recordCommand(this);
		gui.updateSelection();
		gui.highlight(0, stop);
	}

	@Override
	public Memento getMemento() {
		return new MementoSelectAll();
	}

	@Override
	public void executePlay(Memento mem) {
		int stop = engine.getBuffer().length();
		engine.editorSelect(0, stop);
	}

}
