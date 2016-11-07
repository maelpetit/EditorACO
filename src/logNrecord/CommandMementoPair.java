package logNrecord;

import commands.*;
import logNrecord.memento.Memento;

public class CommandMementoPair {
	private RecordableCommand command;
	private Memento memento;
	
	public CommandMementoPair(RecordableCommand comm, Memento mem){
		command = comm;
		memento = mem;
	}

	public RecordableCommand getCommand() {
		return command;
	}

	public Memento getMemento() {
		return memento;
	}

}
