package editor;

import commands.CommandInterface;

public interface Recorder {
	
	public void startRecording();
	public void stopRecording();
	public boolean isRecording();
	public void recordCommand(CommandInterface c);

}
