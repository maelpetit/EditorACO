package commands;

import editor.Engine;
import gui.start.EditorACOGUI;

public class StopRecording extends Command implements CommandInterface {
	
	public StopRecording(Engine eng) {
		super(eng);
	}

	@Override
	public void execute() {
		engine.getRecorder().stopRecording();
	}

}
