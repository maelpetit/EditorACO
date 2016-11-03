package logNrecord;

import java.util.ArrayList;
import java.util.List;

import commands.*;

public class RecorderImpl implements Recorder { //caretaker
	
	private List<CommandMementoPair> cmdList;
	private boolean recording;
	
	public RecorderImpl() {
		cmdList = new ArrayList<>();
		recording = false;
	}
	
	public void eraseRecording(){
		cmdList.clear();
	}
	
	public List<CommandMementoPair> getCmdList() {
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
	public void recordCommand(RecordableCommandInterface c) {
		if(recording){
			System.out.println("DEBUG: recording " + c.getClass());
			cmdList.add(new CommandMementoPair(c, c.getMemento()));
		}
	}

}
