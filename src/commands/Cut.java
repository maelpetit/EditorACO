package commands;

import editor.*;
import gui.start.GUI;
import logNrecord.memento.*;

public class Cut extends RecordCommand implements RecordableCommand,LogCommand {

	public Cut(Engine engine, GUI ui) {
		super(engine, ui);
	}

	@Override
	public void execute() {
		engine.editorCut();
		engine.getRecorder().recordCommand(this);
		addToLog();
	}

	@Override
	public MementoCut getMemento() {
		return new MementoCut();
	}
	
	@Override
	public void addToLog() {
		engine.getLog().recordState(new MementoState(engine.getBuffer(), engine.getSelectionStart(), engine.getSelectionEnd()));
	}

	@Override
	public void executePlay(Memento mem) {
		engine.editorCut();
	}

}
