package logNrecord.memento;

public class MementoSelect implements MementoSelection {
	
	private int start;
	private int stop;
	

	public MementoSelect(int sta, int sto) {
		start = sta;
		stop = sto;
	}

	@Override
	public int getStart() {
		return start;
	}

	@Override
	public int getStop() {
		return stop;
	}

}
