package gui.start;

public interface GUI {
	/**
	 * Method used to insert the inserted text
	 */
	public void insertAction(); 
	
	/**
	 * Method used to play the recorded commands
	 */
	public void playAction();
	
	/**
	 * Method used to execute a Select command
	 */
	public void selectAction();
	
	/**
	 *  Method used to execute a Cut command
	 */
	public void cutAction();
	
	/**
	 *  Method used to execute a Copy command
	 */
	public void copyAction();
	
	/**
	 *  Method used to execute a Paste command
	 */	
	public void pasteAction();
	
	/**
	 *  Method used to execute a StartRecording command
	 */
	public void startRecordingAction();
	
	/**
	 * Method used to execute a StopRecording command 
	 */
	public void stopRecordingAction();
	
	/**
	 * Method to know if you want to erase the recording
	 * @return True if erase recording, False else
	 */
	public boolean eraseRecording();
	
	/**
	 *  Method used to execute a Delete command
	 */
	public void deleteAction();
	
	/**
	 * Method used to execute a Undo command 
	 */
	public void undoAction();
	
	/**
	 *  Method used to execute a Redo command
	 */
	public void redoAction();
	
	/**
	 * Method used to execute a SelectAll command 
	 */
	public void selectAllAction();
	
	/**
	 * Returns the text to be inserted
	 * @return the String to insert
	 */
	public String getText();
	
	/**
	 * Returns the start of the graphical selection
	 * @return the start of the graphical selection
	 */
	public int getGUIStartSelection();
	
	/**
	 * Returns the end of the graphical selection
	 * @return the end of the graphical selection
	 */
	public int getGUIStopSelection();
}
