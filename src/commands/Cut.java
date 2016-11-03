package commands;

import editor.*;
import gui.start.EditorACOGUI;
import logNrecord.MementoState;

public class Cut extends Command implements CommandInterface,RecordableCommand {

	public Cut(Engine engine, EditorACOGUI ui) {
		super(engine, ui);
	}

	@Override
	public CommandInterface execute() {
		this.engine.editorCut();
		return this;
	}

	@Override
	public MementoState getMemento() {
		return new MementoState();
	}
	
	@Override
	public void addToLog() {
		engine.getLog().recordState(new MementoState(engine.getBuffer(), engine.getSelectionStart(), engine.getSelectionEnd()));
	}

}
