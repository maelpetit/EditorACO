package commands;

import editor.Engine;

public class Select extends Command implements CommandInterface {

	private int start;
	private int stop;
	
	public Select(Engine eng) {
		super(eng);
	}

	public int getStart() {
		return start;
	}

	public int getStop() {
		return stop;
	}
	
	public void setStart(int start) {
		this.start = start;
	}

	public void setStop(int stop) {
		this.stop = stop;
	}
	
	@Override
	public CommandInterface execute() {
		engine.editorSelect(start, stop);
		return this;
	}

}
