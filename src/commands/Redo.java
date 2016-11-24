package commands;

import editor.Engine;
import gui.start.EditorACOGUI;

public class Redo extends Command implements CommandInterface {

	public Redo(Engine eng) {
		super(eng);
	}

	@Override
	public void execute() {
		if(engine.redoAvailable()){
			engine.editorRedo();
		}else
			System.out.println("Redo Unavailable");
		
		}

}
