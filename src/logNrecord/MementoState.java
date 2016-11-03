package logNrecord;

public class MementoState implements Memento {
	
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
	public String getContent() {
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
