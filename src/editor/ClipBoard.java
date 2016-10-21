package editor;


/**
 * 
 * @author Jules PAGET Maël PETIT
 * @version 1.0
 */


public class ClipBoard {
	
	/**
	 * The content of the clipboard
	 */
	private String content;
	
	/**
	 * Constructor for the clipboard
	 */
	public ClipBoard(){
		content = "";
	}

	/**
	 * Getter for the content of the clipboard
	 * @return the content of the clipboard
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Setter for the content of the clipboard
	 * @param content the new content of the clipboard
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
