package test;

import static org.junit.Assert.*;

import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.*;
import gui.start.MockGUI;

public class EditorTest {
	
	private MockGUI mockUI;
	private static PrintStream out;
	
	@BeforeClass
	public static void setUpOnce() {
		out = System.out;
		System.setErr(out);
	}

	@Before
	public void setUpEachTime() {
		mockUI = new MockGUI();
	}
	
	public void insert(String insert){
		mockUI.setText(insert);
		mockUI.insertAction();
	}
	
	public void select( int start, int stop){
		mockUI.setGUIStart(start);
		mockUI.setGUIStop(stop);
		mockUI.selectAction();
	}
	
	public void hideSysOut(){
		System.setErr(new PrintStream(new OutputStream() {
		    public void write(int b) {
		    }
		}));
	}
	
	public void showSysOut(){
		System.setErr(out);
	}
	
	
	@Test
	public void testInsert0(){
		String insert = "bonjour";
		insert(insert);
		assertTrue(mockUI.getEngine().getBuffer().equals(insert));
	}
	
	@Test
	public void testSelect0(){
		String insert = "je suis jules";
		insert(insert);
		select(6,8);
		assertTrue(mockUI.getEngine().getSelectionStart() == 6 && mockUI.getEngine().getSelectionEnd() == 8);
	}
	
	@Test
	public void testSelect1(){
		String insert = "je suis jules";
		insert(insert);
		select(25, 54);
		assertTrue(mockUI.getEngine().getSelectionStart() == insert.length() 
				&& mockUI.getEngine().getSelectionEnd() == insert.length());
	}
	
	@Test
	public void testCopy0(){
		String insert = "je suis jules";
		insert(insert);
		select(0, insert.length());
		mockUI.copyAction();
		assertTrue(mockUI.getEngine().getClipboard().equals(insert));
	}
	
	@Test
	public void testCut0(){
		String insert = "je suis jules";
		insert(insert);
		select(0, insert.length());
		mockUI.cutAction();
		assertTrue(mockUI.getEngine().getBuffer().isEmpty() && mockUI.getEngine().getClipboard().equals(insert));
	}
	
	@Test
	public void testDelete0(){
		String insert = "je suis jules";
		insert(insert);
		select(0, insert.length());
		mockUI.deleteAction();
		assertTrue(mockUI.getEngine().getBuffer().isEmpty());
	}
	
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

	@Test
	public void testSelectAll0(){
		String insert = "je suis jules";
		insert(insert);
		mockUI.selectAllAction();
		assertTrue(mockUI.getEngine().getSelectionStart() == 0
				&& mockUI.getEngine().getSelectionEnd() == insert.length());
		assertTrue(mockUI.getEngine().getSelection().equals(insert));
	}
	
	@Test
	public void testUndo0(){
		String insert = "je suis jules";
		insert(insert);
		mockUI.undoAction();
		assertTrue(mockUI.getEngine().getBuffer().isEmpty());
	}
	
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
	
	@Test
	public void testRedo0(){
		String insert = "je suis jules";
		insert(insert);
		mockUI.undoAction();
		mockUI.redoAction();
		assertTrue(mockUI.getEngine().getBuffer().equals(insert));
	}
	
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
	
	@Test
	public void testStartRecording0(){
		mockUI.startRecordingAction();
		assertTrue(mockUI.getEngine().getRecorder().isRecording());
	}
	
	@Test
	public void testStopRecording0(){
		mockUI.startRecordingAction();
		mockUI.stopRecordingAction();
		assertFalse(mockUI.getEngine().getRecorder().isRecording());
	}
	
	@Test
	public void testPlayRecording0(){
		mockUI.startRecordingAction();
		String insert = "je suis jules";
		insert(insert);
		mockUI.stopRecordingAction();
		mockUI.playAction();
		assertTrue(mockUI.getEngine().getBuffer().equals(insert+insert));
	}
	
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