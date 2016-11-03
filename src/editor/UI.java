package editor;

import commands.*;
import logNrecord.MementoState;

public class UI {

	public UI(){
	}

	public CommandInterface executeCommand(CommandInterface comm){
		return comm.execute();
	}

}
