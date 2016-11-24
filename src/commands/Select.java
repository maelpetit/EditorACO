package commands;

import editor.Engine;
import gui.start.EditorACOGUI;
import logNrecord.memento.Memento;
import logNrecord.memento.MementoSelect;

public class Select extends RecordCommand implements RecordableCommand {

	private int start;
	private int stop;
	
	public Select(Engine eng, int selectionStart, int selectionStop) {
		super(eng);
		start = selectionStart;
		stop = selectionStop;
	}

	public int getStart() {
		return start;
	}

	public int getStop() {
		return stop;
	}
	
	@Override
	public void execute() {
		engine.editorSelect(start, stop);
		engine.getRecorder().recordCommand(this);
	}

	@Override
	public MementoSelect getMemento() {
		return new MementoSelect(start, stop);
	}

	@Override
	public void executePlay(Memento mem) {
		MementoSelect memS = (MementoSelect) mem;
		engine.editorSelect(memS.getStart(), memS.getStop());
	}
}
