package commands;

import editor.*;
import gui.start.GUI;
import logNrecord.memento.Memento;
import logNrecord.memento.MementoInsert;
import logNrecord.memento.MementoState;

/**
 * Insert Command class
 * 
 * @author Forget, Paget, Petit
 *
 */
public class Insert extends Command implements RecordableCommand,LogCommand {

	/**
	 * The text to insert with this Insert command
	 */
	private String insert;

	/**
	 * Constructor for a Insert command
	 * @param engine the engine
	 * @param GUI the GUI
	 */
	public Insert(Engine engine, GUI GUI) {
		super(engine, GUI);
		insert = "";
	}

	@Override
	public void execute() {
		insert = gui.getText();
		engine.editorInsert(insert);
		engine.getRecorder().recordCommand(this);
		addToLog();
	}

	/**
	 * Setter for the text to insert
	 * @param content the text to insert
	 */
	public void setContent(String content){
		insert = content;
	}
	
	@Override
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
