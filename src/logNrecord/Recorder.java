package logNrecord;

import commands.RecordableCommandInterface;
import editor.Engine;

public interface Recorder {
	
	public void startRecording();
	public void stopRecording();
	public boolean isRecording();
	public void recordCommand(RecordableCommandInterface c);

}
