package commands;

import logNrecord.MementoState;

public interface RecordableCommandInterface extends CommandInterface, RecordableCommand {
	void executePlay(MementoState mem);
}
