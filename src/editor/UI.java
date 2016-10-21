package editor;

import java.util.HashMap;

import commands.*;

public class UI {
	
	private final HashMap<String, CommandInterface> commands;
	
	public UI(Engine engine){
		commands = new HashMap<>();
		commands.put("cut", new Cut(engine));
		commands.put("copy", new Copy(engine));
		commands.put("paste", new Paste(engine));
		commands.put("select", new Select(engine));
		commands.put("insert", new Insert(engine));
		commands.put("delete", new Delete(engine));
	}
	
	public CommandInterface executeCommand(String comm){
		if(commands.containsKey(comm))
			return commands.get(comm).execute();
		return null;
	}

	public CommandInterface getCommand(String string) {
		return commands.get(string);
	}

}
