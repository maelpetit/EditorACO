package commands;

import editor.Engine;
import gui.start.EditorACOGUI;

public class Redo extends Command implements CommandInterface {

	public Redo(Engine eng ,EditorACOGUI ui) {
		super(eng, ui);
	}

	@Override
	public void execute() {
		if(engine.redoAvailable()){
			engine.editorRedo();
			gui.enableUndoButton();
			if(!engine.redoAvailable()){
				gui.disableRedoButton();
			}
		}else
			System.out.println("Redo Unavailable");
		
		gui.updateBuffer();
		gui.updateSelection();
		gui.highlight(engine.getSelectionStart(), engine.getSelectionEnd());
	}

}
