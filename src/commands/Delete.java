package commands;

import editor.*;

public class Delete extends Command implements CommandInterface {

	public Delete(Engine engine) {
		super(engine);
	}

	@Override
	public CommandInterface execute() {
		engine.editorInsert("");
		return this;
	}

}
