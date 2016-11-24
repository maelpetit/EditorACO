package commands;

import java.util.List;

import editor.*;
import gui.start.EditorACOGUI;
import logNrecord.*;
import logNrecord.memento.MementoState;

public class Play extends RecordCommand implements LogCommand {
	
	public Play(Engine eng) {
		super(eng);
	}

	@Override
	public void execute() {
		List<CommandMementoPair> cmds = engine.getRecorder().getCmdList();
		for(int i = 0;i < cmds.size(); i++){
			cmds.get(i).getCommand().executePlay(cmds.get(i).getMemento());
		}
		addToLog();
	}

	@Override
	public void addToLog() {
		engine.getLog().recordState(new MementoState(engine.getBuffer(), engine.getSelectionStart(), engine.getSelectionEnd()));
	}

}
