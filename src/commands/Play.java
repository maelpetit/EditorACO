package commands;

import java.util.List;

import editor.*;
import gui.start.GUI;
import logNrecord.*;
import logNrecord.memento.MementoState;

/**
 * Play Command class
 * 
 * @author Forget, Paget, Petit
 *
 */
public class Play extends Command implements LogCommand {
	
	/**
	 * Constructor for a Play command
	 * @param eng the engine
	 * @param gui the GUI
	 */
	public Play(Engine eng, GUI gui) {
		super(eng, gui);
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
