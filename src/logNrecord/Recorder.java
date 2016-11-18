package logNrecord;

import java.util.List;

import commands.RecordableCommand;

public interface Recorder {
	
	public void startRecording();
	public void stopRecording();
	public boolean isRecording();
	public void recordCommand(RecordableCommand c);
	public List<CommandMementoPair> getCmdList();
	public void eraseRecording();

}
