package editor;
/**
 * 
 * @author Jules PAGET Maël PETIT
 * @version 1.0
 */


public class Buffer {
	
	/**
	 * Buffer content
	 */
	private String content;
	/**
	 * Clipboard instance
	 */
	private ClipBoard clipBoard;
	/**
	 * TextSelection instance
	 */
	private TextSelection selection;
	
	/**
	 * Constructor for the buffer
	 */
	public Buffer(){
		content = "";
		clipBoard = new ClipBoard();
		selection = new TextSelection();
	}

	/**
	 * Getter for the content of the buffer
	 * @return the content of the buffer
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Setter for the content of the buffer
	 * @param content the new content of the buffer
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Getter for the clipboard
	 * @return
	 */
	public ClipBoard getClipBoard() {
		return clipBoard;
	}

	/**
	 * Getter for the selection 
	 * @return
	 */
	public TextSelection getSelection() {
		return selection;
	}

}
