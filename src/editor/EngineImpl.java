package editor;

import logNrecord.*;
import logNrecord.memento.MementoState;

/**
 * The concrete Engine class
 * 
 * @author Forget, Paget, Petit
 *
 */
public class EngineImpl implements Engine
{

	/**
	 * The buffer
	 */
	private Buffer buffer;
	
	/**
	 * The logger
	 */
	private Log log;
	
	/**
	 * The recorder
	 */
	private Recorder record;
	
	/**
	 * Constructor for a concrete Engine
	 */
	public EngineImpl() {
		buffer = new Buffer();
		log = new LogImpl();
		log.recordState(new MementoState());
		record = new RecorderImpl();
	}
	
	
	@Override
	public String getBuffer()
	{
		return buffer.getContent();
	}

	
	@Override
	public String getSelection()
	{
		return buffer.getSelection().getContent();
	}

	
	@Override
	public String getClipboard()
	{
		return buffer.getClipBoard().getContent();
	}
	
	@Override
	public Recorder getRecorder() {
		return record;
	}

	
	@Override
	public void editorInsert(String substring)
	{
		System.err.println("DEBUG: inserting text [" + substring + "]");
		buffer.setContent(buffer.getContent().substring(0, buffer.getSelection().getStart()) 
				+ substring
				+ buffer.getContent().substring(buffer.getSelection().getStop(), buffer.getContent().length()));
		buffer.getSelection().setContent("");
		buffer.getSelection().setStop(buffer.getSelection().getStart() + substring.length());
		buffer.getSelection().setStart(buffer.getSelection().getStop());
	}

	
	@Override
	public void editorSelect(int start, int stop)
	{
		System.err.println("DEBUG: selecting interval [" + start + "," + stop + "]");
		if(stop > buffer.getContent().length()){
			stop = buffer.getContent().length();
			System.err.println("DEBUG: stop > buffer.getContent().length()");
		}
		if(start > buffer.getContent().length()){
			start = buffer.getContent().length();
			System.err.println("DEBUG: start > buffer.getContent().length()");
		}
		buffer.getSelection().setContent(buffer.getContent().substring(start, stop));
		buffer.getSelection().setStart(start);
		buffer.getSelection().setStop(stop);
	}

	
	@Override
	public void editorCopy()
	{
		System.err.println("DEBUG: performing Copy") ;
		buffer.getClipBoard().setContent(buffer.getSelection().getContent());

	}

	
	@Override
	public void editorCut() 
	{
		System.err.println("DEBUG: performing Cut") ;
		editorCopy();
		buffer.setContent(buffer.getContent().substring(0, buffer.getSelection().getStart())
				+ buffer.getContent().substring(buffer.getSelection().getStop(), buffer.getContent().length()));
		buffer.getSelection().setStop(buffer.getSelection().getStart());
		buffer.getSelection().setContent("");
	}

	
	@Override
	public void editorPaste()
	{
		System.err.println("DEBUG: performing Paste");
		buffer.setContent(buffer.getContent().substring(0, buffer.getSelection().getStart()) 
				+ buffer.getClipBoard().getContent() 
				+ buffer.getContent().substring(buffer.getSelection().getStop(), buffer.getContent().length()));
		buffer.getSelection().setStart(buffer.getSelection().getStart() + buffer.getClipBoard().getContent().length());
		buffer.getSelection().setStop(buffer.getSelection().getStart());
	}
	
	
	@Override
	public void editorUndo()
	{
		// TODO probleme de modification de la selection quand on undo et redo
		System.err.println("DEBUG: performing Undo") ;
		MementoState m = log.getPrevState();
		buffer.setContent(m.getText());
		buffer.getSelection().setStart(m.getStart());
		buffer.getSelection().setStop(m.getStop());
	}

	
	@Override
	public void editorRedo()
	{
		System.err.println("DEBUG: performing Redo");
		MementoState m = log.getNextState();
		buffer.setContent(m.getText());
		buffer.getSelection().setStart(m.getStart());
		buffer.getSelection().setStop(m.getStop());
	}

	
	@Override
	public Log getLog() {
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
