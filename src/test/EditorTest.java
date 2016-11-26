package test;

import static org.junit.Assert.*;

import org.junit.*;
import gui.start.MockGUI;

public class EditorTest {
	
	private MockGUI mockUI;
	
	@BeforeClass
	public static void setUpOnce() {
		
	}

	@Before
	public void setUpEachTime() {
		mockUI = new MockGUI();
	}
	
	public void insert(String insert){
		mockUI.setText(insert);
		mockUI.insertAction();
	}
	
	@Test
	public void testInsert0(){
		String insert = "bonjour";
		insert(insert);
		assertTrue(mockUI.getEngine().getBuffer().equals(insert));
	}
	
	public void select( int start, int stop){
		mockUI.setGUIStart(start);
		mockUI.setGUIStop(stop);
		mockUI.selectAction();
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
	public void testRedo0(){
		String insert = "je suis jules";
		insert(insert);
		mockUI.undoAction();
		mockUI.redoAction();
		assertTrue(mockUI.getEngine().getBuffer().equals(insert));
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
	
	@After
	public void cleanEachTime() {
		// TODO Auto-generated method stub

	}

}