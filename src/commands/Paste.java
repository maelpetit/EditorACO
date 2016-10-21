package commands;

import editor.*;

public class Paste extends Command implements CommandInterface {

	public Paste(Engine engine) {
		super(engine);
	}

	@Override
	public CommandInterface execute() {
		engine.editorPaste();
		return this;
	}

}
