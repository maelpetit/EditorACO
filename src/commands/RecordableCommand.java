package commands;

import logNrecord.memento.Memento;

/**
 * Interface for recordable commands (ie for use with Play)
 * 
 * @author Forget, Paget, Petit
 *
 */
public interface RecordableCommand extends CommandInterface{
	
	/**
	 * Returns the memento associated with the command
	 * @return the memento
	 */
	Memento getMemento();
	
	/**
	 * Executes the command in the Play context (ie doesnt add to log)
	 * @param mem
	 */
	void executePlay(Memento mem);
}
