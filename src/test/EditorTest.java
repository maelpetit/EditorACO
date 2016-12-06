package test;

import static org.junit.Assert.*;

import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.*;
import gui.start.MockGUI;

/**
 * The Test class
 * 
 * @author Forget, Paget, Petit
 *
 */
public class EditorTest {
	
	/**
	 * The mock GUI
	 */
	private MockGUI mockUI;
	
	/**
	 * Used to disable/enable the console prints in big tests
	 */
	private static PrintStream out;
	
	@BeforeClass
	public static void setUpOnce() {
		out = System.out;
		System.setErr(out);
	}

	@Before
	public void setUpEachTime() {
		System.err.println("COUCOU");
		mockUI = new MockGUI();
	}
	
	/**
	 * Method used to insert the specified text in the mock GUI 
	 * @param insert the text to insert
	 */
	public void insert(String insert){
		mockUI.setText(insert);
		mockUI.insertAction();
	}
	
	/**
	 * Method used to select text in the mock GUI
	 * @param start the start of the selection
	 * @param stop the end of the selection
	 */
	public void select( int start, int stop){
		mockUI.setGUIStart(start);
		mockUI.setGUIStop(stop);
		mockUI.selectAction();
	}
	
	/**
	 * Hides the consoles prints
	 */
	public void hideSysOut(){
		System.setErr(new PrintStream(new OutputStream() {
		    public void write(int b) {
		    }
		}));
	}
	
	/**
	 * Shows the console prints
	 */
	public void showSysOut(){
		System.setErr(out);
	}
	
	
	/**
	 * Inserts a string and checks the content of the buffer
	 */
	@Test
	public void testInsert0(){
		String insert = "bonjour";
		insert(insert);
		assertTrue(mockUI.getEngine().getBuffer().equals(insert));
	}
	
	/**
	 * Selects a portion of the text and checks if the selection is right
	 */
	@Test
	public void testSelect0(){
		String insert = "je suis jules";
		insert(insert);
		select(6,8);
		assertTrue(mockUI.getEngine().getSelectionStart() == 6 && mockUI.getEngine().getSelectionEnd() == 8);
	}
	
	/**
	 * Selects on the right of the text and check if the selection is at the end of the buffer
	 */
	@Test
	public void testSelect1(){
		String insert = "je suis jules";
		insert(insert);
		select(25, 54);
		assertTrue(mockUI.getEngine().getSelectionStart() == insert.length() 
				&& mockUI.getEngine().getSelectionEnd() == insert.length());
	}
	
	/**
	 * Inserts and copies text, checks the clipboard content
	 */
	@Test
	public void testCopy0(){
		String insert = "je suis jules";
		insert(insert);
		select(0, insert.length());
		mockUI.copyAction();
		assertTrue(mockUI.getEngine().getClipboard().equals(insert));
	}
	
	/**
	 * Inserts and cuts, checks the clipboard and buffer content
	 */
	@Test
	public void testCut0(){
		String insert = "je suis jules";
		insert(insert);
		select(0, insert.length());
		mockUI.cutAction();
		assertTrue(mockUI.getEngine().getBuffer().isEmpty() && mockUI.getEngine().getClipboard().equals(insert));
	}
	
	/**
	 * Inserts and deletes, checks if the buffer is empty
	 */
	@Test
	public void testDelete0(){
		String insert = "je suis jules";
		insert(insert);
		select(0, insert.length());
		mockUI.deleteAction();
		assertTrue(mockUI.getEngine().getBuffer().isEmpty());
	}
	
	/**
	 * Inserts, copies and pastes, check the content of the buffer
	 */
	@Test
	public void testPaste0(){
		String insert = "je suis jules";
		insert(insert);
		select(0, insert.length());
		mockUI.copyAction();
		select(insert.length(), insert.length());
		mockUI.pasteAction();
		assertTrue(mockUI.getEngine().getBuffer().equals(insert+insert));
	}

	/**
	 * Inserts and selects all, check the selection content, start and stop
	 */
	@Test
	public void testSelectAll0(){
		String insert = "je suis jules";
		insert(insert);
		mockUI.selectAllAction();
		assertTrue(mockUI.getEngine().getSelectionStart() == 0
				&& mockUI.getEngine().getSelectionEnd() == insert.length());
		assertTrue(mockUI.getEngine().getSelection().equals(insert));
	}
	
	/**
	 * Inserts and undos, check if the buffer is empty
	 */
	@Test
	public void testUndo0(){
		String insert = "je suis jules";
		insert(insert);
		mockUI.undoAction();
		assertTrue(mockUI.getEngine().getBuffer().isEmpty());
	}
	
	/**
	 * Inserts 50 times and undos 50 times, checks if the buffer is empty
	 */
	@Test
	public void testUndo50(){
		hideSysOut();
		String insert = ".";
		for(int i = 0; i<50; i++){
			insert(insert);
		}
		for(int i = 0; i<50; i++){
			mockUI.undoAction();
		}
		showSysOut();
		assertTrue(mockUI.getEngine().getBuffer().isEmpty());
	}

	/**
	 * Inserts 5000 times and undos 5000 times, checks if the buffer is empty
	 */
	@Test
	public void testUndo5000(){
		hideSysOut();
		String insert = ".";
		for(int i = 0; i<5000; i++){
			insert(insert);
		}
		for(int i = 0; i<5000; i++){
			mockUI.undoAction();
		}
		showSysOut();
		assertTrue(mockUI.getEngine().getBuffer().isEmpty());
	}
	
	/**
	 * Inserts, undos and redos, checks the buffer content of the buffer
	 */
	@Test
	public void testRedo0(){
		String insert = "je suis jules";
		insert(insert);
		mockUI.undoAction();
		mockUI.redoAction();
		assertTrue(mockUI.getEngine().getBuffer().equals(insert));
	}
	
	/**
	 * Inserts 50 times, undos 50 times and redos 50 times, checks the buffer content of the buffer
	 */
	@Test
	public void testRedo50(){
		hideSysOut();
		String insert = ".";
		for(int i = 0; i<50; i++){
			insert(insert);
		}
		String temp = mockUI.getEngine().getBuffer();
		for(int i = 0; i<50; i++){
			mockUI.undoAction();
		}
		for(int i = 0; i<50; i++){
			mockUI.redoAction();
		}
		showSysOut();
		assertTrue(mockUI.getEngine().getBuffer().equals(temp));
	}
	
	/**
	 * Starts the recording, check if the recording has started
	 */
	@Test
	public void testStartRecording0(){
		mockUI.startRecordingAction();
		assertTrue(mockUI.getEngine().getRecorder().isRecording());
	}
	
	/**
	 * Stops the recording, checks if the recording has stopped
	 */
	@Test
	public void testStopRecording0(){
		mockUI.startRecordingAction();
		mockUI.stopRecordingAction();
		assertFalse(mockUI.getEngine().getRecorder().isRecording());
	}
	
	/**
	 * Starts, stops and play the recording, check the content of the buffer
	 */
	@Test
	public void testPlayRecording0(){
		mockUI.startRecordingAction();
		String insert = "je suis jules";
		insert(insert);
		mockUI.stopRecordingAction();
		mockUI.playAction();
		assertTrue(mockUI.getEngine().getBuffer().equals(insert+insert));
	}
	
	/**
	 * Starts, stops and restarts the recording, checks if the previous recording has been erased
	 */
	@Test
	public void testEraseRecording0(){
		mockUI.startRecordingAction();
		String insert = "je suis jules";
		insert(insert);
		mockUI.stopRecordingAction();
		assertFalse(mockUI.getEngine().getRecorder().getCmdList().isEmpty());
		mockUI.startRecordingAction();
		assertTrue(mockUI.getEngine().getRecorder().getCmdList().isEmpty());
	}
	
	/**
	 * Starts, stops, restarts, restops and plays the recording, checks the content of the buffer and the list of recorded commands
	 */
	@Test
	public void testEraseRecording1(){
		mockUI.setEraseRecording(false);
		mockUI.startRecordingAction();
		String insert = "je suis jules";
		insert(insert);
		mockUI.stopRecordingAction();
		mockUI.startRecordingAction();
		insert(insert);
		mockUI.stopRecordingAction();
		mockUI.playAction();
		assertTrue(mockUI.getEngine().getBuffer().equals(insert+insert+insert+insert));
		assertTrue(mockUI.getEngine().getRecorder().getCmdList().size() == 2);
	}
	
	@After
	public void cleanEachTime() {
		
	}

}