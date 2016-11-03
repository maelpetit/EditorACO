package commands;

import editor.Engine;
import gui.start.EditorACOGUI;

public class Undo extends Command implements CommandInterface {

	public Undo(Engine eng, EditorACOGUI ui) {
		super(eng, ui);
	}

	@Override
	public void execute() {
		if(engine.undoAvailable()){
			engine.editorUndo();
			gui.enableRedoButton();
			if(!engine.undoAvailable()){
				gui.disableUndoButton();
			}
		}else
			System.out.println("Undo Unavailable");
	}

}
