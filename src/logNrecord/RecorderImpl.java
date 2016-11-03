package logNrecord;

import java.util.ArrayList;
import java.util.List;

import commands.*;
import editor.Engine;

public class RecorderImpl implements Recorder { //caretaker
	
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
	public void recordCommand(CommandInterface c, String content, Engine engine) {
		if(recording){
			System.out.println("DEBUG: recording command " + c.getClass());
			cmdList.add(c);
		}
	}

}
