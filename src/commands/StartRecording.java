package commands;

import javax.swing.JOptionPane;

import editor.Engine;
import gui.start.EditorACOGUI;
import logNrecord.RecorderImpl;

public class StartRecording extends Command implements CommandInterface {
	private RecorderImpl record;
	
	public StartRecording(Engine eng, EditorACOGUI ui, RecorderImpl rec) {
		super(eng, ui);
		record = rec;
	}

	@Override
	public void execute() {
		record.startRecording();
		if(!record.getCmdList().isEmpty()){
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
				record.eraseRecording();
			}
		}
	}

}
