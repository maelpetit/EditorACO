package commands;

import editor.Engine;
import gui.start.EditorACOGUI;
import logNrecord.memento.Memento;
import logNrecord.memento.MementoSelect;

public class Select extends RecordCommand implements RecordableCommand {

	private int start;
	private int stop;
	
	public Select(Engine eng, EditorACOGUI ui) {
		super(eng, ui);
	}

	public int getStart() {
		return start;
	}

	public int getStop() {
		return stop;
	}
	
	@Override
	public void execute() {
		start = gui.getGUIStartSelection();
		stop = gui.getGUIStopSelection();
		engine.editorSelect(start, stop);
		engine.getRecorder().recordCommand(this);
		gui.updateSelection();
		gui.highlight(start, stop);
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
