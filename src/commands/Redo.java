package commands;

import editor.Engine;

public class Redo extends Command implements CommandInterface {

	public Redo(Engine eng) {
		super(eng);
	}

	@Override
	public CommandInterface execute() {
		engine.editorRedo();
		return this;
	}

}
