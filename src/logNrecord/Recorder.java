package logNrecord;

import commands.CommandInterface;
import editor.Engine;

public interface Recorder {
	
	public void startRecording();
	public void stopRecording();
	public boolean isRecording();
	public void recordCommand(CommandInterface c, String content, Engine engine);

}
