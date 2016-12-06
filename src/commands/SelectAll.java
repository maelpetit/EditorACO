package commands;

import editor.Engine;
import gui.start.GUI;
import logNrecord.memento.Memento;
import logNrecord.memento.MementoSelectAll;

/**
 * SelectAll Command class
 * 
 * @author Forget, Paget, Petit
 *
 */
public class SelectAll extends Command implements RecordableCommand {

	/**
	 * Constructor for a SelectAll command
	 * @param eng the engine
	 * @param ui the GUI
	 */
	public SelectAll(Engine eng, GUI ui) {
		super(eng, ui);
	}

	@Override
	public void execute() {
		int stop = engine.getBuffer().length();
		engine.editorSelect(0, stop);
		engine.getRecorder().recordCommand(this);
	}

	@Override
	public Memento getMemento() {
		return new MementoSelectAll();
	}

	@Override
	public void executePlay(Memento mem) {
		int stop = engine.getBuffer().length();
		engine.editorSelect(0, stop);
	}

}
