package commands;

import editor.Engine;
import gui.start.GUI;

public class StopRecording extends Command implements CommandInterface {
	
	public StopRecording(Engine eng, GUI GUI) {
		super(eng, GUI);
	}

	@Override
	public void execute() {
		engine.getRecorder().stopRecording();
	}

}
