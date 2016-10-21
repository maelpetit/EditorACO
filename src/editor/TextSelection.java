package editor;


/**
 * 
 * @author Jules PAGET Maël PETIT
 * @version 1.0
 */


public class TextSelection {
	
	/**
	 * The content of the selection
	 */
	private String content;
	/**
	 * the starting point of the selection in the buffer
	 */
	private int start;
	/**
	 * the stopping point of the selection in the buffer (buffer.content.charAt(stop) not included)
	 */
	private int stop;

	/**
	 * Constructor for the selection
	 */
	public TextSelection(){
		content = "";
		start = 0;
		stop = 0;
	}
	
	/**
	 * Getter for the content of the selection
	 * @return the content of the selection
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Setter for the content of the selection
	 * @param content the new content of the selection
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Getter for the starting point of the selection
	 * @return the starting point of the selection
	 */
	public int getStart() {
		return start;
	}

	/**
	 * Setter for the starting point of the selection
	 * @param start the new starting point of the selection
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * Getter for the stopping point of the selection
	 * @return the stoping point of the selection
	 */
	public int getStop() {
		return stop;
	}

	/**
	 * Setter for the stopping point of the selection
	 * @param stop the new stopping point of the selection
	 */
	public void setStop(int stop) {
		this.stop = stop;
	}

}
