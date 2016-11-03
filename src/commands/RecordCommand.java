package commands;

import editor.Engine;
import gui.start.EditorACOGUI;
import logNrecord.RecorderImpl;

public class RecordCommand extends Command {
	
	protected RecorderImpl record;

	public RecordCommand(Engine eng, EditorACOGUI ui, RecorderImpl rec) {
		super(eng, ui);
		record = rec;
	}

}
