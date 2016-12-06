package logNrecord;

import java.util.ArrayList;
import java.util.List;

import logNrecord.memento.MementoState;

/**
 * The concrete Log class
 * @author Forget, Paget, Petit
 *
 */
public class LogImpl implements Log {
	
	/**
	 * The list of logged states
	 */
	private List<MementoState> stateList;
	
	/**
	 * The current state
	 */
	private int currentState;
	
	/**
	 * Constructor for a concrete Log
	 */
	public LogImpl(){
		stateList = new ArrayList<>();
		currentState = 0;
	}

	@Override
	public void recordState(MementoState ms) {
		if(currentState != 0){
			for(int i = 0; i < currentState; i++){
				stateList.remove(0);//removing the states that were overwritten by an Undo followed by a buffer-modifying action
			}
			currentState = 0;
		}
		stateList.add(0,ms);
		System.err.println("DEBUG: State = " + (stateList.size()-currentState) + " currentBuffer = " + ms.getText());
	}
	
	@Override
	public MementoState getPrevState(){
		if(undoAvailable()){
			currentState++;
			MementoState m = stateList.get(currentState);
			System.err.println("DEBUG: State = " + (stateList.size()-currentState) + " currentBuffer = " + m.getText());
			return m;
		}else{
			System.err.println("No previous state available");
			return null;
		}
	}

	@Override
	public MementoState getNextState() {
		if(redoAvailable()){
			currentState--;
			MementoState m = stateList.get(currentState);
			System.err.println("DEBUG: currentState = " + currentState + " currentBuffer = " + m.getText());
			return m;
		}else{
			System.err.println("No next state available");
			return null;
		}
	}

	@Override
	public boolean undoAvailable() {
		return currentState < stateList.size()-1;
	}

	@Override
	public boolean redoAvailable() {
		return currentState > 0;
	}

	

}
