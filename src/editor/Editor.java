package editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.activation.ActivationGroupDesc.CommandEnvironment;
import java.util.List;

import commands.*;

public class Editor {
	private Engine engine;
	private UI ui;
	private RecorderImpl record;
	static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
	
	public Editor(){
		engine = new EngineImpl();
		ui = new UI(engine);
		record = new RecorderImpl();
	}
	

	public void startRecording(){
		record.startRecording();
	}
	public void endRecording(){
		record.stopRecording();
	}
	public void playRecording(){
		CommandInterface c;
		
		List<MyEntry<CommandInterface,String>> cmds = record.getCmdList();
		for(int i = 0;i < cmds.size(); i++){
			c = cmds.get(i).getKey();
			c.execute();
		}
	}
	
	public static void main(String[] args)
	{
		Editor edit = new Editor();
		String inputLine;
		char commandLetter;
		CommandInterface c;
		String content;
		
		System.out.println("Welcome to Engine 9.99 (c) 2015 EIT Digital Rennes") ;
		System.out.println("-----------------------------------------------------------") ;
				
		System.out.println("Enter command (I/S/C/X/V/D/R/E/P/Z/Y/Q) > ") ;
		try
		{
			inputLine = keyboard.readLine();
		} catch (IOException e)
		{
			System.out.println("Unable to read standard input");
			inputLine = "W";
		} 
		commandLetter = Character.toUpperCase(inputLine.charAt(0)) ;
		while (commandLetter != 'Q') /* Quit */
		{
			c = null;
			content = "";
			switch (commandLetter)
			{
				case 'I': /* Insert */
					content = inputLine.substring(2);
					((Insert) edit.ui.getCommand("insert")).setString(content);
					c = edit.ui.executeCommand("insert");
					break;
				case 'S': /* Select */
					String numberString="";
					try
					{
						String[] arguments = inputLine.substring(2).split("\\s+");
						content = inputLine.substring(2);
						numberString = arguments[0];
						int start  = Integer.parseInt(numberString);
						numberString = arguments[1];
						int stop  = Integer.parseInt(numberString);
						((Select) edit.ui.getCommand("select")).setStart(start);
						((Select) edit.ui.getCommand("select")).setStop(stop);
						c = edit.ui.executeCommand("select");
					}
					catch (Exception e)
					{
						System.out.println("Invalid number: " + numberString);
					}
					
					break;
				case 'X': /* Cut */
					c = edit.ui.executeCommand("cut");
					break;
				case 'C': /* Copy */
					c = edit.ui.executeCommand("copy");
					break;
				case 'V': /* Paste */
					c = edit.ui.executeCommand("paste");
					break;
				case 'D': /* Delete */
					c = edit.ui.executeCommand("delete");
					break;
				case 'R': /* Record */
					//TODO verifier que ca enregistre pas deja
					edit.startRecording();
					break;
				case 'E': /* End Recording */
					//TODO verifier que ca enregistre
					edit.endRecording();
					break;
				case 'P': /* Play recording */
					if(!edit.record.isRecording())
						edit.playRecording();
					else
						System.out.println("Recording in progress... End the recording before playing it.");
					break;
				case 'Z': /* Undo */
					break;
				case 'Y': /* Redo */
					break;
				default: 
					System.out.println("Unrecognized command, please try again:") ;
					break;
						
			}
			//recording the command
			if(edit.record.isRecording() && c != null){
				if(c.getClass() == Select.class){
					c = new Select(edit.engine);
					String[] selectArgs = content.split("\\s+");
					((Select) c).setStart(Integer.parseInt(selectArgs[0]));
					((Select) c).setStop(Integer.parseInt(selectArgs[1]));
				}else if(c.getClass() == Insert.class){
					c = new Insert(edit.engine);
					((Insert) c).setString(content);
				}
				edit.record.recordCommand(c, content);
			}
			
			System.out.println("-----------------------------------------------------");
			System.out.println("[" + edit.engine.getBuffer() + "]");
			System.out.println("-----------------------------------------------------");
			System.out.println("[" + edit.engine.getSelection() + "]");
			System.out.println("-----------------------------------------------------");
			System.out.println("[" + edit.engine.getClipboard() + "]");
			System.out.println("-----------------------------------------------------");

			System.out.println("Enter command (I/S/C/X/V/D/R/E/P/Z/Y/Q) > ") ;	
			try
			{
				inputLine = keyboard.readLine();
			} catch (IOException e)
			{
				System.out.println("Unable to read standard input");
				inputLine = "W";
			} 
			commandLetter = Character.toUpperCase(inputLine.charAt(0)) ;
		}
		System.out.println ("Goodbye") ;
	}

}
