package logNrecord;

import java.util.ArrayList;
import java.util.List;

import commands.*;

/**
 * The concrete Recorder class
 * 
 * @author Forget, Paget, Petit
 *
 */
public class RecorderImpl implements Recorder {
	
	/**
	 * The list of recorded Commands with their Mementos
	 */
	private List<CommandMementoPair> cmdList;
	
	/**
	 * The Recording boolean
	 */
	private boolean recording;
	
	/**
	 * Constructor for the concrete Recorder
	 */
	public RecorderImpl() {
		cmdList = new ArrayList<>();
		recording = false;
	}
	
	@Override
	public void eraseRecording(){
		cmdList.clear();
	}
	
	@Override
	public List<CommandMementoPair> getCmdList() {
		return cmdList;
	}

	@Override
	public void startRecording(){
		recording = true;
	}
	
	@Override
	public void stopRecording(){
		recording = false;
	}

	@Override
	public boolean isRecording() {
		return recording;
	}

	@Override
	public void recordCommand(RecordableCommand c) {
		if(recording){
			System.err.println("DEBUG: recording " + c.getClass());
			cmdList.add(new CommandMementoPair(c, c.getMemento()));
		}
	}

}
