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
			c = new Select(engine);
			String[] selectArgs = content.split("\\s+");
			((Select) c).setStart(Integer.parseInt(selectArgs[0]));
			((Select) c).setStop(Integer.parseInt(selectArgs[1]));
		}else if(c instanceof Insert){
			c = new Insert(engine);
			((Insert) c).setString(content);
		}
		cmdList.add(c);
	}

}
