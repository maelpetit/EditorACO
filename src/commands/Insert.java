package commands;

import editor.*;
import gui.start.EditorACOGUI;
import logNrecord.MementoState;
import logNrecord.RecorderImpl;

public class Insert extends RecordCommand implements RecordableCommandInterface {
	
	private String insert;

	public Insert(Engine engine, EditorACOGUI ui, RecorderImpl rec) {
		super(engine, ui, rec);
		insert = "";
	}

	@Override
	public void execute() {
		insert = gui.getText();
		engine.editorInsert(insert);
		record.recordCommand(this);
		addToLog();
		if(!engine.redoAvailable()){
			gui.disableRedoButton();
		}
	}
	
	public void setContent(String content){
		insert = content;
	}
	
	public MementoState getMemento(){
		return new MementoState(insert, 0, 0);
	}

	@Override
	public void addToLog() {
		engine.getLog().recordState(new MementoState(engine.getBuffer(), engine.getSelectionStart(), engine.getSelectionEnd()));
		gui.enableUndoButton();
	}

	@Override
	public void executePlay(MementoState mem) {
		engine.editorInsert(mem.getContent());
	}

}
