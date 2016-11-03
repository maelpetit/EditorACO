package commands;

import editor.Engine;
import gui.start.EditorACOGUI;
import logNrecord.MementoState;

public class Select extends Command implements CommandInterface,RecordableCommand {

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
	public CommandInterface execute() {
		start = gui.getStartSelection();
		stop = gui.getStopSelection();
		engine.editorSelect(start, stop);
		return this;
	}

	@Override
	public MementoState getMemento() {
		return new MementoState("", start, stop);
	}

	@Override
	public void addToLog() {
		engine.getLog().recordState(new MementoState(engine.getBuffer(), engine.getSelectionStart(), engine.getSelectionEnd()));
	}
}
