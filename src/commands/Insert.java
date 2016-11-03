package commands;

import editor.*;
import gui.start.EditorACOGUI;
import logNrecord.MementoState;

public class Insert extends Command implements CommandInterface,RecordableCommand {
	
	private String insert;

	public Insert(Engine engine, EditorACOGUI ui) {
		super(engine, ui);
		insert = "";
	}

	@Override
	public CommandInterface execute() {
		insert = gui.getText();
		engine.editorInsert(insert);
		return this;
	}
	
	public MementoState getMemento(){
		return new MementoState(insert, 0, 0);
	}

	@Override
	public void addToLog() {
		engine.getLog().recordState(new MementoState(engine.getBuffer(), engine.getSelectionStart(), engine.getSelectionEnd()));
	}

}
