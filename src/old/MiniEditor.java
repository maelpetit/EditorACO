package old;


/**
 * 
 * @author Jules PAGET Maël PETIT
 * @version 1.0
 */
public interface MiniEditor
{
	public String getBuffer();
	public String getSelection();
	public String getClipboard();

	public void editorInsert(String substring);
	public void editorSelect(int start, int stop);
	public void editorCopy();
	public void editorCut();
	public void editorPaste();
	public void editorStartRecording();
	public void editorEndRecording();
	public void editorPlayRecording();
	public void editorUndo();
	public void editorRedo();
}
