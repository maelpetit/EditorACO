package editor;

public class MementoState implements Memento {
	
	private String bufferState;
	
	public MementoState(String content){
		bufferState = content;
	}
	
	public MementoState(){
		bufferState = "";
	}

	@Override
	public void setContent(String content) {
		bufferState = content;
	}

	@Override
	public String getContent() {
		return bufferState;
	}

}
