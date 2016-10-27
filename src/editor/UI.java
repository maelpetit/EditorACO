package editor;

import commands.*;
import log.MementoState;

public class UI {

	public UI(){
	}

	public CommandInterface executeCommand(CommandInterface comm){
		return comm.execute();
	}

}
