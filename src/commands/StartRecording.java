package commands;

import javax.swing.JOptionPane;

import editor.Engine;
import gui.start.EditorACOGUI;

public class StartRecording extends Command implements CommandInterface {
	
	public StartRecording(Engine eng, EditorACOGUI ui) {
		super(eng, ui);
	}

	@Override
	public void execute() {
		engine.getRecorder().startRecording();
		if(!engine.getRecorder().getCmdList().isEmpty()){
			Object[] options = {"Keep","Erase"};
			int keep = JOptionPane.showOptionDialog(gui,
					"Erase the last recording ?",
					"Do you wish to keep the last recording/nor erase and start a new one ?",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,     //do not use a custom Icon
					options,  //the titles of buttons
					options[0]); //default button title
			if(keep == JOptionPane.NO_OPTION){
				engine.getRecorder().eraseRecording();
			}
		}
	}

}
