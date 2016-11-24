package commands;

import javax.swing.JOptionPane;

import editor.Engine;
import gui.start.EditorACOGUI;

public class StartRecording extends Command implements CommandInterface {
	
	public StartRecording(Engine eng) {
		super(eng);
	}

	@Override
	public void execute() {
		engine.getRecorder().startRecording();
	}

}
