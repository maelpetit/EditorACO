package commands;

import editor.Engine;
import gui.start.EditorACOGUI;
import logNrecord.RecorderImpl;

public class StopRecording extends Command implements CommandInterface {

	private RecorderImpl record;
	
	public StopRecording(Engine eng, EditorACOGUI ui, RecorderImpl rec) {
		super(eng, ui);
		record = rec;
	}

	@Override
	public void execute() {
		record.stopRecording();
	}

}
