package commands;

import editor.Engine;
import gui.start.GUI;

public class StartRecording extends Command implements CommandInterface {
	
	public StartRecording(Engine eng, GUI ui) {
		super(eng, ui);
	}

	@Override
	public void execute() {
		engine.getRecorder().startRecording();
		if(gui.eraseRecording()){
			engine.getRecorder().eraseRecording();
		}
	}

}
