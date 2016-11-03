package commands;

import editor.Engine;
import gui.start.EditorACOGUI;

public class Redo extends Command implements CommandInterface {

	public Redo(Engine eng ,EditorACOGUI ui) {
		super(eng, ui);
	}

	@Override
	public CommandInterface execute() {
		engine.editorRedo();
		return this;
	}

}
