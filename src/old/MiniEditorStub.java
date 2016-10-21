
package old;
import editor.Buffer;

/**
 * 
 * @author Jules PAGET Maël PETIT
 * @version 1.0
 */
public class MiniEditorStub implements MiniEditor
{
	/**
	 * the buffer
	 */
	private Buffer buffer = new Buffer();
	
	/**
	 * Getter for the content of the buffer
	 * @return the content of the buffer
	 */
	@Override
	public String getBuffer()
	{
		return buffer.getContent();
	}

	/**
	 * Getter for the content of the selection
	 * @return the content of the selection
	 */
	@Override
	public String getSelection()
	{
		return buffer.getSelection().getContent();
	}

	/**
	 * Getter for the content of the clipboard
	 * @return the content of the clipboard
	 */
	@Override
	public String getClipboard()
	{
		return buffer.getClipBoard().getContent();
	}

	/**
	 * Method to insert text to the buffer
	 * @param substring the string to insert
	 */
	@Override
	public void editorInsert(String substring)
	{
		System.out.println("DEBUG: inserting text [" + substring + "]");
		buffer.setContent(buffer.getContent().substring(0, buffer.getSelection().getStart()) 
				+ substring
				+ buffer.getContent().substring(buffer.getSelection().getStop(), buffer.getContent().length()));
		buffer.getSelection().setContent("");
		buffer.getSelection().setStop(buffer.getSelection().getStart() + substring.length());
		buffer.getSelection().setStart(buffer.getSelection().getStop());
	}

	/**
	 * Method to select some text
	 * @param start the start of the selection
	 * @param stop the end of the selection (content[stop] not included)
	 */
	@Override
	public void editorSelect(int start, int stop)
	{
		System.out.println("DEBUG: selecting interval [" + start + "," + stop + "]");
		buffer.getSelection().setContent(buffer.getContent().substring(start, stop));
		buffer.getSelection().setStart(start);
		buffer.getSelection().setStop(stop);
	}

	/**
	 * Method to copy the selection to the clipboard
	 */
	@Override
	public void editorCopy()
	{
		System.out.println("DEBUG: performing Copy") ;
		buffer.getClipBoard().setContent(buffer.getSelection().getContent());
	}

	/**
	 * Method to copy the selection to the clipboard and cut the selection from the buffer
	 */
	@Override
	public void editorCut() 
	{
		System.out.println("DEBUG: performing Cut") ;
		editorCopy();
		buffer.setContent(buffer.getContent().substring(0, buffer.getSelection().getStart())
				+ buffer.getContent().substring(buffer.getSelection().getStop(), buffer.getContent().length()));
		buffer.getSelection().setStop(buffer.getSelection().getStart());
		buffer.getSelection().setContent("");
	}

	/**
	 * Method to delete the selection and copy the clipboard to the selection
	 */
	@Override
	public void editorPaste()
	{
		System.out.println("DEBUG: performing Paste") ;
		buffer.setContent(buffer.getContent().substring(0, buffer.getSelection().getStart()) 
				+ buffer.getClipBoard().getContent() 
				+ buffer.getContent().substring(buffer.getSelection().getStop(), buffer.getContent().length()));
		buffer.getSelection().setStart(buffer.getSelection().getStop() + buffer.getClipBoard().getContent().length());
		buffer.getSelection().setStop(buffer.getSelection().getStart());
	}

	/**
	 * 
	 */
	@Override
	public void editorStartRecording()
	{
		System.out.println("DEBUG: performing Record start") ;
	}

	@Override
	public void editorEndRecording()
	{
		System.out.println("DEBUG: performing Record end") ;
	}

	@Override
	public void editorPlayRecording()
	{
		System.out.println("DEBUG: performing Play") ;
	}

	@Override
	public void editorUndo()
	{
		System.out.println("DEBUG: performing Undo") ;
	}

	@Override
	public void editorRedo()
	{
		System.out.println("DEBUG: performing Redo") ;
	}

}
