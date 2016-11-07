package commands;

import java.util.List;

import editor.*;
import gui.start.EditorACOGUI;
import logNrecord.*;
import logNrecord.memento.Memento;
import logNrecord.memento.MementoState;

public class Play extends RecordCommand implements LogCommand {
	
	public Play(Engine eng, EditorACOGUI gui, RecorderImpl rec) {
		super(eng, gui, rec);
	}

	@Override
	public void execute() {
		List<CommandMementoPair> cmds = record.getCmdList();
		for(int i = 0;i < cmds.size(); i++){
			cmds.get(i).getCommand().executePlay(cmds.get(i).getMemento());
		}
		addToLog();
		gui.updateBuffer();
		gui.updateClipboard();
		gui.updateSelection();
		gui.highlight(engine.getSelectionStart(), engine.getSelectionEnd());
	}

	@Override
	public void addToLog() {
		engine.getLog().recordState(new MementoState(engine.getBuffer(), engine.getSelectionStart(), engine.getSelectionEnd()));
		gui.enableUndoButton();
	}

}
