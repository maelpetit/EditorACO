package commands;

import editor.Engine;
import gui.start.EditorACOGUI;

public class Undo extends Command implements CommandInterface {

	public Undo(Engine eng, EditorACOGUI ui) {
		super(eng, ui);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CommandInterface execute() {
		engine.editorUndo();
		return this;
	}

}
