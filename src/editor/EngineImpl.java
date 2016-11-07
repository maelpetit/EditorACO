package editor;

import logNrecord.LogImpl;
import logNrecord.memento.MementoState;

public class EngineImpl implements Engine
{

	/**
	 * the buffer
	 */
	private Buffer buffer;
	private LogImpl log;
	
	public EngineImpl() {
		buffer = new Buffer();
		log = new LogImpl();
		log.recordState(new MementoState());
	}
	
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
		if(stop > buffer.getContent().length()){
			stop = buffer.getContent().length();
			System.out.println("DEBUG: stop > buffer.getContent().length()");
		}
		if(start > buffer.getContent().length()){
			start = buffer.getContent().length();
			System.out.println("DEBUG: start > buffer.getContent().length()");
		}
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
		if(buffer.getSelection().getStart() != buffer.getSelection().getStop()){//we dont copy when no text is selected
			buffer.getClipBoard().setContent(buffer.getSelection().getContent());
		}else
			System.out.println("DEBUG: Nothing to copy");
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
		System.out.println("DEBUG: performing Paste");
		buffer.setContent(buffer.getContent().substring(0, buffer.getSelection().getStart()) 
				+ buffer.getClipBoard().getContent() 
				+ buffer.getContent().substring(buffer.getSelection().getStop(), buffer.getContent().length()));
		buffer.getSelection().setStart(buffer.getSelection().getStop());
		buffer.getSelection().setStop(buffer.getSelection().getStart());
	}

	@Override
	public void editorUndo()
	{
		// TODO probleme de modification de la selection quand on undo et redo
		System.out.println("DEBUG: performing Undo") ;
		MementoState m = log.getPrevState();
		buffer.setContent(m.getText());
		buffer.getSelection().setStart(m.getStart());
		buffer.getSelection().setStop(m.getStop());
	}

	@Override
	public void editorRedo()
	{
		System.out.println("DEBUG: performing Redo");
		MementoState m = log.getNextState();
		buffer.setContent(m.getText());
		buffer.getSelection().setStart(m.getStart());
		buffer.getSelection().setStop(m.getStop());
	}

	public LogImpl getLog() {
		return log;
	}

	@Override
	public boolean redoAvailable() {
		return log.redoAvailable();
	}

	@Override
	public boolean undoAvailable() {
		return log.undoAvailable();
	}

	@Override
	public int getSelectionStart() {
		return buffer.getSelection().getStart();
	}

	@Override
	public int getSelectionEnd() {
		return buffer.getSelection().getStop();
	}

}
