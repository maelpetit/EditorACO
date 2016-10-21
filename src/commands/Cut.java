package commands;

import editor.*;

public class Cut extends Command implements CommandInterface {

	public Cut(Engine engine) {
		super(engine);
	}

	@Override
	public CommandInterface execute() {
		this.engine.editorCut();
		return this;
	}

}
