package logNrecord;

import java.util.ArrayList;
import java.util.List;

import logNrecord.memento.MementoState;

public class LogImpl implements Log {
	
	private List<MementoState> stateList;
	private int currentState;
//	private final int MAX_LOG_SIZE = 50;
	
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
//		else if(stateList.size() >= MAX_LOG_SIZE){
//			stateList.remove(MAX_LOG_SIZE-1);
//		}
		stateList.add(0,ms);
		System.out.println("DEBUG: State = " + (stateList.size()-currentState) + " currentBuffer = " + ms.getText());
	}
	
	public MementoState getPrevState(){
		if(undoAvailable()){
			currentState++;
			MementoState m = stateList.get(currentState);
			System.out.println("DEBUG: State = " + (stateList.size()-currentState) + " currentBuffer = " + m.getText());
			return m;
		}else{
			System.out.println("No previous state available");
			return null;
		}
	}

	@Override
	public MementoState getNextState() {
		if(redoAvailable()){
			currentState--;
			MementoState m = stateList.get(currentState);
			System.out.println("DEBUG: currentState = " + currentState + " currentBuffer = " + m.getText());
			return m;
		}else{
			System.out.println("No next state available");
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
