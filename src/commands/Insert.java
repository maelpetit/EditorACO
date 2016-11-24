package commands;

import editor.*;
import gui.start.EditorACOGUI;
import logNrecord.memento.Memento;
import logNrecord.memento.MementoInsert;
import logNrecord.memento.MementoState;

public class Insert extends RecordCommand implements RecordableCommand,LogCommand {

	private String insert;

	public Insert(Engine engine, String ins) {
		super(engine);
		insert = ins;
	}

	@Override
	public void execute() {
		engine.editorInsert(insert);
		engine.getRecorder().recordCommand(this);
		addToLog();
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
	}

	@Override
	public void executePlay(Memento mem) {
		engine.editorInsert(((MementoInsert) mem).getText());
	}

}
