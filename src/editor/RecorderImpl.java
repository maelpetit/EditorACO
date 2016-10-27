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
	public void recordCommand(CommandInterface c, String content, Engine engine) {
		if(c instanceof Select){
			Select s = new Select(engine);
			s.setStart(((Select) c).getStart());
			s.setStop(((Select) c).getStop());
			c = s;
		}else if(c instanceof Insert){
			c = new Insert(engine);
			((Insert) c).setString(content);
		}
		cmdList.add(c);
	}

}
