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

public class MockGUI implements GUI {
	
	private Engine engine;
	private String text;
	private int startGUISelection;
	private int stopGUISelection;

	public MockGUI() {
		engine = new EngineImpl();
		text = "";
	}
	
	public Engine getEngine(){
		return engine;
	}
	
	public void setText(String t){
		text = t;
	}
	
	public void setGUIStart(int start){
		startGUISelection = start;
	}
	
	public void setGUIStop(int stop){
		stopGUISelection = stop;
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
		return true;
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
