package commands;

import editor.*;
import gui.start.EditorACOGUI;
import logNrecord.RecorderImpl;
import logNrecord.memento.Memento;
import logNrecord.memento.MementoInsert;
import logNrecord.memento.MementoState;

public class Insert extends RecordCommand implements RecordableCommand,LogCommand {
	
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
		gui.updateBuffer();
		gui.updateSelection();
		gui.highlight(engine.getSelectionStart(), engine.getSelectionEnd());
	}
	
	public void setContent(String content){
		insert = content;
	}
	
	public MementoInsert getMemento(){
		return new MementoInsert(insert);
	}

	@Override
	public void addToLog() {
		engine.getLog().recordState(new MementoState(engine.getBuffer(), engine.getSelectionStart(), engine.getSelectionEnd()));
		gui.enableUndoButton();
	}

	@Override
	public void executePlay(Memento mem) {
		engine.editorInsert(((MementoInsert) mem).getText());
	}

}
