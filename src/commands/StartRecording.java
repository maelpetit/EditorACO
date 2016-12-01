package commands;

import editor.Engine;
import gui.start.GUI;

/**
 * StartRecording Command class
 * 
 * @author Forget, Paget, Petit
 *
 */
public class StartRecording extends Command implements CommandInterface {
	
	/**
	 * Constructor for a StartRecording command
	 * @param engine the engine
	 * @param ui the GUI
	 */
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
