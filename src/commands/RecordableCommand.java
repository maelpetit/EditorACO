package commands;

import logNrecord.*;

public interface RecordableCommand {
	MementoState getMemento();
	void addToLog();
}
