package logNrecord;

import logNrecord.memento.MementoState;

/**
 * The Log interface
 * 
 * @author Forget, Paget, Petit
 *
 */
public interface Log {
	
	/**
	 * Logs the specified state
	 * @param ms the MementoState to log
	 */
	public void recordState(MementoState ms);
	
	/**
	 * Returns True if a Redo is available
	 * (ie a next state is available)
	 * @return True if Redo available, False else
	 */
	public boolean redoAvailable();
	
	/**
	 * Returns True if an Undo is available
	 * (ie a previous state is available)
	 * @return True if Undo available, False else
	 */
	public boolean undoAvailable();
	
	/**
	 * Returns the previous state
	 * @return the previous MementoState
	 */
	public MementoState getPrevState();
	
	/**
	 * Returns the next state
	 * @return the next MementoState
	 */
	public MementoState getNextState();
}
