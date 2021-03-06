package logNrecord.memento;

public class MementoState implements MementoText, MementoSelection {
	
	private String bufferState;
	private int startSelect;
	private int stopSelect;
	
	public MementoState(String content, int startSel, int stopSel){
		bufferState = content;
		startSelect = startSel;
		stopSelect = stopSel;
	}
	
	public MementoState(){
		bufferState = "";
		startSelect = 0;
		stopSelect = 0;
	}

	@Override
	public String getText() {
		return bufferState;
	}

	@Override
	public int getStart() {
		return startSelect;
	}

	@Override
	public int getStop() {
		return stopSelect;
	}

}
