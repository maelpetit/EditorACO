package logNrecord;

import commands.RecordableCommand;
import editor.Engine;

public interface Recorder {
	
	public void startRecording();
	public void stopRecording();
	public boolean isRecording();
	public void recordCommand(RecordableCommand c);

}
