package editor;

import java.util.ArrayList;
import java.util.List;

import commands.*;

public class RecorderImpl implements Recorder {
	
	private List<MyEntry<CommandInterface, String>> cmdList;
	private boolean recording;
	
	public RecorderImpl() {
		cmdList = new ArrayList<>();
		recording = false;
	}
	
	public List<MyEntry<CommandInterface, String>> getCmdList() {
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
	public void recordCommand(CommandInterface c, String content) {
		MyEntry<CommandInterface, String> entry = new MyEntry<CommandInterface, String>(c, content);
		cmdList.add(entry);
		System.out.println(c);
	}

}
