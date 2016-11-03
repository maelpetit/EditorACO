//package old;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.List;
//
//import commands.*;
//import editor.Engine;
//import editor.EngineImpl;
//import editor.UI;
//import logNrecord.RecorderImpl;
//
//public class Editor {
//	private Engine engine;
//	private UI ui;
//	private RecorderImpl record;
//	static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
//	
//	public Editor(){
//		engine = new EngineImpl();
//		ui = new UI();
//		record = new RecorderImpl();
//	}
//	
//
//	public void startRecording(){
//		record.startRecording();
//	}
//	public void endRecording(){
//		record.stopRecording();
//	}
//	public void playRecording(){
//		CommandInterface c;
//		
//		List<CommandInterface> cmds = record.getCmdList();
//		for(int i = 0;i < cmds.size(); i++){
//			c = cmds.get(i);
//			c.execute();
//		}
//	}
//	
//	public static void main(String[] args)
//	{
//		Editor edit = new Editor();
//		String inputLine;
//		char commandLetter;
//		CommandInterface c;
//		String content;
//		
//		System.out.println("Welcome to Engine 9.99 (c) 2015 EIT Digital Rennes") ;
//		System.out.println("-----------------------------------------------------------") ;
//				
//		System.out.println("Enter command (I/S/C/X/V/D/R/E/P/Z/Y/Q) > ") ;
//		try
//		{
//			inputLine = keyboard.readLine();
//		} catch (IOException e)
//		{
//			System.out.println("Unable to read standard input");
//			inputLine = "W";
//		} 
//		commandLetter = Character.toUpperCase(inputLine.charAt(0)) ;
//		while (commandLetter != 'Q') /* Quit */
//		{
//			c = null;
//			content = "";
//			switch (commandLetter)
//			{
//				case 'I': /* Insert */
//					content = inputLine.substring(2);
//					c = new Insert(edit.engine);
//					((Insert) c).setString(content);
//					c.execute();
//					break;
//				case 'S': /* Select */
//					String numberString="";
//					try
//					{
//						String[] arguments = inputLine.substring(2).split("\\s+");
//						content = inputLine.substring(2);
//						numberString = arguments[0];
//						int start  = Integer.parseInt(numberString);
//						numberString = arguments[1];
//						int stop  = Integer.parseInt(numberString);
//						c = new Select(edit.engine);
//						((Select) c).setStart(start);
//						((Select) c).setStop(stop);
//						c.execute();
//					}
//					catch (Exception e)
//					{
//						System.out.println("Invalid number: " + numberString);
//					}
//					
//					break;
//				case 'X': /* Cut */
//					c = new Cut(edit.engine);
//					c.execute();
//					break;
//				case 'C': /* Copy */
//					c = new Copy(edit.engine);
//					c.execute();
//					break;
//				case 'V': /* Paste */
//					c = new Paste(edit.engine);
//					c.execute();
//					break;
//				case 'D': /* Delete */
//					c = new Delete(edit.engine);
//					c.execute();
//					break;
//				case 'R': /* Record */
//					//TODO verifier que ca enregistre pas deja
//					edit.startRecording();
//					break;
//				case 'E': /* End Recording */
//					//TODO verifier que ca enregistre
//					edit.endRecording();
//					break;
//				case 'P': /* Play recording */
//					if(!edit.record.isRecording())
//						edit.playRecording();
//					else
//						System.out.println("Recording in progress... End the recording before playing it.");
//					break;
//				case 'Z': /* Undo */
//					break;
//				case 'Y': /* Redo */
//					break;
//				default: 
//					System.out.println("Unrecognized command, please try again:") ;
//					break;
//						
//			}
//			//recording the command
//			if(edit.record.isRecording() && c != null){
//				edit.record.recordCommand(c, content, edit.engine);
//			}
//			
//			System.out.println("-----------------------------------------------------");
//			System.out.println("[" + edit.engine.getBuffer() + "]");
//			System.out.println("-----------------------------------------------------");
//			System.out.println("[" + edit.engine.getSelection() + "]");
//			System.out.println("-----------------------------------------------------");
//			System.out.println("[" + edit.engine.getClipboard() + "]");
//			System.out.println("-----------------------------------------------------");
//
//			System.out.println("Enter command (I/S/C/X/V/D/R/E/P/Z/Y/Q) > ") ;	
//			try
//			{
//				inputLine = keyboard.readLine();
//			} catch (IOException e)
//			{
//				System.out.println("Unable to read standard input");
//				inputLine = "W";
//			} 
//			commandLetter = Character.toUpperCase(inputLine.charAt(0)) ;
//		}
//		System.out.println ("Goodbye") ;
//	}
//
//}
