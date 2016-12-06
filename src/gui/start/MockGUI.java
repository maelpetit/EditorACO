package gui.start;

import commands.Copy;
import commands.Cut;
import commands.Delete;
import commands.Insert;
import commands.Paste;
import commands.Play;
import commands.Redo;
import commands.Select;
import commands.SelectAll;
import commands.StartRecording;
import commands.StopRecording;
import commands.Undo;
import editor.Engine;
import editor.EngineImpl;

/**
 * The mock GUI
 * 
 * @author Forget, Paget, Petit
 *
 */
public class MockGUI implements GUI {
	
	/**
	 * The Engine
	 */
	private Engine engine;
	
	/**
	 * The mock entered text 
	 */
	private String text;
	
	/**
	 * The mock start of the GUI selection
	 */
	private int startGUISelection;
	
	/**
	 * The mock end of the GUI selection
	 */
	private int stopGUISelection;
	
	/**
	 * Boolean to mock the action of asking to erase the recording
	 */
	private boolean eraseRecording;

	/**
	 * Constructor for a mock GUI
	 */
	public MockGUI() {
		engine = new EngineImpl();
		text = "";
		eraseRecording = true;
	}
	
	/**
	 * Getter for the Engine
	 * @return the Engine
	 */
	public Engine getEngine(){
		return engine;
	}
	
	/**
	 * Setter for the mock entered text
	 * (ie simulation of typed text)
	 * @param t the entered text
	 */
	public void setText(String t){
		text = t;
	}
	
	/**
	 * Setter for the mock start of the GUI selection
	 * (ie simulation of text selection)
	 * @param start the start of the selection
	 */
	public void setGUIStart(int start){
		startGUISelection = start;
	}
	
	/**
	 * Setter for the mock end of the GUI selection
	 * (ie simulation of text selection)
	 * @param stop the end of the selection
	 */
	public void setGUIStop(int stop){
		stopGUISelection = stop;
	}
	
	/**
	 * Setter for the eraseRecording boolean
	 * (ie the GUI asked if the recording has to be erased)
	 * @param erase True for the recording to be erased 
	 */
	public void setEraseRecording(boolean erase){
		eraseRecording = erase;
	}

	@Override
	public void insertAction() {
		new Insert(engine, this).execute();
	}

	@Override
	public void playAction() {
		new Play(engine, this).execute();
	}

	@Override
	public void selectAction() {
		new Select(engine, this).execute();
	}

	@Override
	public void cutAction() {
		new Cut(engine, this).execute();
	}

	@Override
	public void copyAction() {
		new Copy(engine, this).execute();
	}

	@Override
	public void pasteAction() {
		new Paste(engine, this).execute();
	}

	@Override
	public void startRecordingAction() {
		new StartRecording(engine, this).execute();
	}

	@Override
	public void stopRecordingAction() {
		new StopRecording(engine, this).execute();
	}

	@Override
	public void deleteAction() {
		new Delete(engine, this).execute();
	}

	@Override
	public void undoAction() {
		new Undo(engine, this).execute();
	}

	@Override
	public void redoAction() {
		new Redo(engine, this).execute();
	}

	@Override
	public void selectAllAction() {
		new SelectAll(engine, this).execute();
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public boolean eraseRecording() {
		return eraseRecording;
	}

	@Override
	public int getGUIStartSelection() {
		return startGUISelection;
	}

	@Override
	public int getGUIStopSelection() {
		return stopGUISelection;
	}

}
