package logNrecord;

import commands.*;
import logNrecord.memento.Memento;

/**
 * The Command/Memento Pair class
 * used to record commands
 * 
 * @author Forget, Paget, Petit
 *
 */
public class CommandMementoPair {
	
	/**
	 * The command to store
	 */
	private RecordableCommand command;
	
	/**
	 * The associated memento
	 */
	private Memento memento;
	
	/**
	 * Constructor for a Command/Memento Pair
	 * @param comm the Command
	 * @param mem the Memento
	 */
	public CommandMementoPair(RecordableCommand comm, Memento mem){
		command = comm;
		memento = mem;
	}

	/**
	 * Getter for the Command
	 * @return the Command
	 */
	public RecordableCommand getCommand() {
		return command;
	}

	/**
	 * Getter for the memento
	 * @return the Memento
	 */
	public Memento getMemento() {
		return memento;
	}

}
