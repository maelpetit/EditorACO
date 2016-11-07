package commands;

import logNrecord.memento.Memento;

public interface RecordableCommand extends CommandInterface{
	
	Memento getMemento();
	void executePlay(Memento mem);
}
