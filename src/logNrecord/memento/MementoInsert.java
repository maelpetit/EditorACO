package logNrecord.memento;

public class MementoInsert implements MementoText {

	private String text;
	
	public MementoInsert(String t) {
		text = t;
	}

	@Override
	public String getText() {
		return text;
	}

}
