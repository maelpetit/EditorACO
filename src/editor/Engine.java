package editor;

public interface Engine
{
	public String getBuffer();
	public String getSelection();
	public String getClipboard();

	public void editorInsert(String substring);
	public void editorSelect(int start, int stop);
	public void editorCopy();
	public void editorCut();
	public void editorPaste();
	public void editorUndo();
	public void editorRedo();
}
