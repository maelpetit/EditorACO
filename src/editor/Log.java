package editor;

public interface Log {
	
	public void recordState(MementoState ms);
	public boolean redoAvailable();
	public boolean undoAvailable();
	public int getCurrentState();
	public MementoState getPrevState();
	public MementoState getNextState();
}
