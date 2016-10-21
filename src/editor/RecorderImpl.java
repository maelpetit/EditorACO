package editor;

import java.util.ArrayList;
import java.util.List;

import commands.*;

public class RecorderImpl implements Recorder {
	
	private List<CommandInterface> cmdList;
	private boolean recording;
	
	public RecorderImpl() {
		cmdList = new ArrayList<>();
		recording = false;
	}
	
	public List<CommandInterface> getCmdList() {
		return cmdList;
	}

	public void startRecording(){
		recording = true;
	}
	
	public void stopRecording(){
		recording = false;
	}

	public boolean isRecording() {
		return recording;
	}

	@Override
	public void recordCommand(CommandInterface c) {
		cmdList.add(c);
	}

}
