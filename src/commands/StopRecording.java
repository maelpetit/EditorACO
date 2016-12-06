package commands;

import editor.Engine;
import gui.start.GUI;

/**
 * StopRecording Command class
 * 
 * @author Forget, Paget, Petit
 *
 */
public class StopRecording extends Command implements CommandInterface {
	
	/**
	 * Constructor for a StopRecording command
	 * @param eng the engine
	 * @param ui the GUI
	 */
	public StopRecording(Engine eng, GUI ui) {
		super(eng, ui);
	}

	@Override
	public void execute() {
		engine.getRecorder().stopRecording();
	}

}
