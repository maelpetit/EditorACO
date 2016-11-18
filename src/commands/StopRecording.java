package commands;

import editor.Engine;
import gui.start.EditorACOGUI;

public class StopRecording extends Command implements CommandInterface {
	
	public StopRecording(Engine eng, EditorACOGUI ui) {
		super(eng, ui);
	}

	@Override
	public void execute() {
		engine.getRecorder().stopRecording();
	}

}
