package commands;

import editor.Engine;

public class Undo extends Command implements CommandInterface {

	public Undo(Engine eng) {
		super(eng);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CommandInterface execute() {
		engine.editorUndo();
		return this;
	}

}
