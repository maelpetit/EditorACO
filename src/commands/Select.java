package commands;

import editor.Engine;
import gui.start.EditorACOGUI;
import logNrecord.MementoState;
import logNrecord.RecorderImpl;

public class Select extends RecordCommand implements RecordableCommandInterface {

	private int start;
	private int stop;
	
	public Select(Engine eng, EditorACOGUI ui, RecorderImpl rec) {
		super(eng, ui, rec);
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
		record.recordCommand(this);
	}

	@Override
	public MementoState getMemento() {
		return new MementoState("", start, stop);
	}

	@Override
	public void addToLog() {
		//never called because the state of the buffer doesnt change
	}

	@Override
	public void executePlay(MementoState mem) {
		engine.editorSelect(mem.getStart(), mem.getStop());
	}
}
