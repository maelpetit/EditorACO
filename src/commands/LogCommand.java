package commands;

/**
 * Interface for loggable commands (ie for use with Undo/Redo)
 * 
 * @author Forget, Paget, Petit
 *
 */
public interface LogCommand extends CommandInterface {

	/**
	 * Methods to add the command to the log
	 */
	void addToLog();
}
