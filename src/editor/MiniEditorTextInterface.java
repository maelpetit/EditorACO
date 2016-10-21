package editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MiniEditorTextInterface
{
	static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args)
	{
		Engine engine = new EngineImpl() ;
		String inputLine;
		char commandLetter;
		
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
			switch (commandLetter)
			{
				case 'I': /* Insert */
					engine.editorInsert(inputLine.substring(2));
					break;
				case 'S': /* Select */
					String numberString="";
					try
					{
						String[] arguments = inputLine.substring(2).split("\\s+");
						numberString = arguments[0];
						int start  = Integer.parseInt(numberString);
						numberString = arguments[1];
						int stop  = Integer.parseInt(numberString);
						engine.editorSelect(start, stop);
					}
					catch (Exception e)
					{
						System.out.println("Invalid number: " + numberString);
					}
					break;
				case 'C': /* Copy */
					engine.editorCopy();
					break;
				case 'X': /* cut */
					engine.editorCut();
					break;
				case 'V': /* paste */
					engine.editorPaste();
					break;
				case 'D': /* Delete, i.e. insert empty string */
					engine.editorInsert("");
					break;
//				case 'R': /* start Recording */
//						engine.editorStartRecording();
//					break;
//				case 'E': /* End recording */
//					engine.editorEndRecording();
//					break;
//				case 'P': /* Play recording */
//					engine.editorPlayRecording();
//					break;
				case 'Z': /* undo */
					engine.editorUndo();
					break;
				case 'Y': /* redo */
					engine.editorRedo();
					break;
				default: System.out.println("Unrecognized command, please try again:") ;
					break;
			}
			System.out.println("-----------------------------------------------------");
			System.out.println("[" + engine.getBuffer() + "]");
			System.out.println("-----------------------------------------------------");
			System.out.println("[" + engine.getSelection() + "]");
			System.out.println("-----------------------------------------------------");
			System.out.println("[" + engine.getClipboard() + "]");
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
