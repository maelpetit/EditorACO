package logNrecord;

import java.util.List;

import commands.RecordableCommand;

/**
 * The Recorder interface
 * 
 * @author Forget, Paget, Petit
 *
 */
public interface Recorder {
	
	/**
	 * Starts the recording
	 */
	public void startRecording();
	
	/**
	 * Stops the recording
	 */
	public void stopRecording();
	
	/**
	 * Returns True if the Recorder is recording
	 * @return True if the Recorder is recording
	 */
	public boolean isRecording();
	
	/**
	 * Records the specified Command with its Memento 
	 * @param c the Command to record
	 */
	public void recordCommand(RecordableCommand c);
	
	/**
	 * Getter for the list of recorded Commands
	 * @return the list of recorded Commands
	 */
	public List<CommandMementoPair> getCmdList();
	
	/**
	 * Erases the recording
	 */
	public void eraseRecording();

}
