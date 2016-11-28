package commands;

import editor.Engine;
import gui.start.GUI;

public class Redo extends Command implements CommandInterface {

	public Redo(Engine eng ,GUI ui) {
		super(eng, ui);
	}

	@Override
	public void execute() {
		if(engine.redoAvailable()){
			engine.editorRedo();
		}else
			System.err.println("Redo Unavailable");
	}

}
