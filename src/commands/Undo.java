package commands;

import editor.Engine;
import gui.start.EditorACOGUI;

public class Undo extends Command implements CommandInterface {

	public Undo(Engine eng) {
		super(eng);
	}

	@Override
	public void execute() {
		if(engine.undoAvailable()){
			engine.editorUndo();
		}else
			System.out.println("Undo Unavailable");
		}

}
