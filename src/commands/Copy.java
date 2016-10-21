package commands;

import editor.*;

public class Copy extends Command implements CommandInterface {

	public Copy(Engine engine) {
		super(engine);
	}

	@Override
	public CommandInterface execute() {
		engine.editorCopy();
		return this;
	}

}
