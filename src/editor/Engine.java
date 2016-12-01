package editor;

import logNrecord.*;

/**
 * Interface for the engine
 * 
 * @author Forget, Paget, Petit
 *
 */
public interface Engine
{
	/**
	 * Getter for the content of the buffer
	 * @return the content of the buffer
	 */
	public String getBuffer();
	
	/**
	 * Getter for the content of the selection
	 * @return the content of the selection
	 */
	public String getSelection();
	
	/**
	 * Getter for the start of the selection
	 * @return the start of the selection
	 */
	public int getSelectionStart();
	/**
	 * Getter for the end of the selection
	 * @return the end of the selection
	 */
	public int getSelectionEnd();
	/**
	 * Getter for the content of the clipboard
	 * @return the content of the clipboard
	 */
	public String getClipboard();
	/**
	 * Getter for the recorder
	 * @return the recorder instance
	 */
	public Recorder getRecorder();
	/**
	 * Method to insert text to the buffer
	 * @param substring the string to insert
	 */
	public void editorInsert(String substring);
	/**
	 * Method to select some text
	 * @param start the start of the selection
	 * @param stop the end of the selection (content[stop] not included)
	 */
	public void editorSelect(int start, int stop);
	/**
	 * Method to copy the selection to the clipboard
	 */
	public void editorCopy();
	/**
	 * Method to copy the selection to the clipboard and cut the selection from the buffer
	 */
	public void editorCut();
	/**
	 * Method to delete the selection and copy the clipboard to the selection
	 */
	public void editorPaste();
	/**
	 * Method to undo the previous action from the logger
	 */
	public void editorUndo();
	/**
	 * Method to redo the next action from the logger
	 */
	public void editorRedo();
	/**
	 * Checks if Redo available
	 * @return true if Redo available, false else
	 */
	public boolean redoAvailable();
	/**
	 * Checks if Undo available
	 * @return true if Redo available, false else
	 */
	public boolean undoAvailable();
	/**
	 * Getter for the logger
	 * @return the logger 
	 */
	public Log getLog();
	
}
