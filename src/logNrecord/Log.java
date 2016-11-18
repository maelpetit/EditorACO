package logNrecord;

import logNrecord.memento.MementoState;

public interface Log {
	
	public void recordState(MementoState ms);
	public boolean redoAvailable();
	public boolean undoAvailable();
	public MementoState getPrevState();
	public MementoState getNextState();
}
