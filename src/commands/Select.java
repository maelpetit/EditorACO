package commands;

import editor.Engine;
import gui.start.GUI;
import logNrecord.memento.Memento;
import logNrecord.memento.MementoSelect;

/**
 * Select Command class
 * 
 * @author Forget, Paget, Petit
 *
 */
public class Select extends Command implements RecordableCommand {

	/**
	 * The start of the selection
	 */
	private int start;
	
	/**
	 * The stop of the selection
	 */
	private int stop;
	
	/**
	 * Constructor for a Select command
	 * @param engine the engine
	 * @param ui the GUI
	 */
	public Select(Engine eng, GUI ui) {
		super(eng, ui);
	}

	public int getStart() {
		return start;
	}

	public int getStop() {
		return stop;
	}
	
	@Override
	public void execute() {
		start = gui.getGUIStartSelection();
		stop = gui.getGUIStopSelection();
		engine.editorSelect(start, stop);
		engine.getRecorder().recordCommand(this);
	}

	@Override
	public MementoSelect getMemento() {
		return new MementoSelect(start, stop);
	}

	@Override
	public void executePlay(Memento mem) {
		MementoSelect memS = (MementoSelect) mem;
		engine.editorSelect(memS.getStart(), memS.getStop());
	}
}
