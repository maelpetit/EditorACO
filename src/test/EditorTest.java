package test;

import static org.junit.Assert.*;

import org.junit.*;

import commands.Copy;
import commands.Cut;
import commands.Delete;
import commands.Insert;
import commands.Paste;
import commands.Play;
import commands.Redo;
import commands.Select;
import commands.SelectAll;
import commands.StartRecording;
import commands.StopRecording;
import commands.Undo;
import editor.*;

public class EditorTest {
	
	private Engine engine;
	
	

	@BeforeClass
	public static void setUpOnce() {
		
	}

	@Before
	public void setUpEachTime() {
		engine = new EngineImpl();
	}
	
	public void insert(String insert){
		new Insert(engine, insert).execute();
	}
	
	@Test
	public void testInsert0(){
		String insert = "bonjour";
		insert(insert);
		assertTrue(engine.getBuffer().equals(insert));
	}
	
	public void select( int start, int stop){
		new Select(engine, start, stop).execute();
	}
	
	@Test
	public void testSelect0(){
		String insert = "je suis jules";
		insert(insert);
		select(6,8);
		assertTrue(engine.getSelectionStart() == 6 && engine.getSelectionEnd() == 8);
	}
	
	@Test
	public void testSelect1(){
		String insert = "je suis jules";
		insert(insert);
		new Select(engine, 25, 54).execute();
		assertTrue(engine.getSelectionStart() == insert.length() 
				&& engine.getSelectionEnd() == insert.length());
	}
	
	@Test
	public void testCopy0(){
		String insert = "je suis jules";
		insert(insert);
		select(0, insert.length());
		new Copy(engine).execute();
		assertTrue(engine.getClipboard().equals(insert));
	}
	
	@Test
	public void testCut0(){
		String insert = "je suis jules";
		insert(insert);
		select(0, insert.length());
		new Cut(engine).execute();
		assertTrue(engine.getBuffer().isEmpty() && engine.getClipboard().equals(insert));
	}
	
	@Test
	public void testDelete0(){
		String insert = "je suis jules";
		insert(insert);
		select(0, insert.length());
		new Delete(engine).execute();
		assertTrue(engine.getBuffer().isEmpty());
	}
	
	@Test
	public void testPaste0(){
		String insert = "je suis jules";
		insert(insert);
		select(0, insert.length());
		new Copy(engine).execute();
		select(insert.length(), insert.length());
		new Paste(engine).execute();
		assertTrue(engine.getBuffer().equals(insert+insert));
	}

	@Test
	public void testSelectAll0(){
		String insert = "je suis jules";
		insert(insert);
		new SelectAll(engine).execute();
		assertTrue(engine.getSelectionStart() == 0
				&& engine.getSelectionEnd() == insert.length());
		assertTrue(engine.getSelection().equals(insert));
	}
	
	@Test
	public void testUndo0(){
		String insert = "je suis jules";
		insert(insert);
		new Undo(engine).execute();
		assertTrue(engine.getBuffer().isEmpty());
	}
	
	@Test
	public void testRedo0(){
		String insert = "je suis jules";
		insert(insert);
		new Undo(engine).execute();
		new Redo(engine).execute();
		assertTrue(engine.getBuffer().equals(insert));
	}
	
	public void startRecording(){
		new StartRecording(engine).execute();
	}
	
	public void stopRecording(){
		new StopRecording(engine).execute();
	}
	
	public void playRecording(){
		new Play(engine).execute();
	}
	
	@Test
	public void testStartRecording0(){
		startRecording();
		assertTrue(engine.getRecorder().isRecording());
	}
	
	@Test
	public void testStopRecording0(){
		startRecording();
		stopRecording();
		assertFalse(engine.getRecorder().isRecording());
	}
	
	@Test
	public void testPlayRecording0(){
		startRecording();
		String insert = "je suis jules";
		insert(insert);
		stopRecording();
		playRecording();
		assertTrue(engine.getBuffer().equals(insert+insert));
	}
	
	@After
	public void cleanEachTime() {
		// TODO Auto-generated method stub

	}

}
