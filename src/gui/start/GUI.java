package gui.start;

public interface GUI {
	public void insertAction(); 
	public void playAction();
	public void selectAction();
	public void cutAction();
	public void copyAction();
	public void pasteAction();
	public void startRecordingAction();
	public void stopRecordingAction();
	public boolean eraseRecording();
	public void deleteAction();
	public void undoAction();
	public void redoAction();
	public void selectAllAction();
	public String getText();
	public int getGUIStartSelection();
	public int getGUIStopSelection();
}
