package commands;

import editor.Engine;
import gui.start.GUI;

public class Undo extends Command implements CommandInterface {

	public Undo(Engine eng, GUI ui) {
		super(eng, ui);
	}

	@Override
	public void execute() {
		if(engine.undoAvailable()){
			engine.editorUndo();
			
		}else
			System.err.println("Undo Unavailable");
	}

}
