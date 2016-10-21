package commands;

import editor.EngineImpl;

public class Undo extends Command implements CommandInterface {

	public Undo(EngineImpl eng) {
		super(eng);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CommandInterface execute() {
		engine.editorUndo();
		return this;
	}

}
