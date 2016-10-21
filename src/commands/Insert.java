package commands;

import editor.*;

public class Insert extends Command implements CommandInterface {
	
	private String insert;

	public Insert(Engine engine) {
		super(engine);
		insert = "";
	}
	
	public void setString(String s){
		insert = s;
	}

	@Override
	public CommandInterface execute() {;
		engine.editorInsert(insert);
		return this;
	}

}
