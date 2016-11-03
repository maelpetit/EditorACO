package logNrecord;

import commands.*;

public class CommandMementoPair {
	private RecordableCommandInterface command;
	private MementoState memento;
	
	public CommandMementoPair(RecordableCommandInterface comm, MementoState mem){
		command = comm;
		memento = mem;
	}

	public RecordableCommandInterface getCommand() {
		return command;
	}

	public MementoState getMemento() {
		return memento;
	}

}
