package logNrecord;

import java.util.ArrayList;
import java.util.List;

public class LogImpl implements Log {
	
	private List<MementoState> stateList;
	private int currentState;
	
	public LogImpl(){
		stateList = new ArrayList<>();
		currentState = -1;
	}

	@Override
	public void recordState(MementoState ms) {
		currentState++;
		if(currentState < stateList.size()){
			for(int i = stateList.size()-1; i > currentState-1; i--){
				stateList.remove(i);//removing the states that were overwritten by an Undo followed by a buffer-modifying action
			}
		}
		stateList.add(ms);
		System.out.println("DEBUG: currentState = " + currentState + " currentBuffer = " + ms.getContent());
	}

	public int getCurrentState() {
		return currentState;
	}
	
	public MementoState getPrevState(){
		if(undoAvailable()){
			currentState--;
			MementoState m = stateList.get(currentState);
			System.out.println("DEBUG: currentState = " + currentState + " currentBuffer = " + m.getContent());
			return m;
		}else{
			System.out.println("No previous state available");
			return null;
		}
	}

	@Override
	public MementoState getNextState() {
		if(redoAvailable()){
			currentState++;
			MementoState m = stateList.get(currentState);
			System.out.println("DEBUG: currentState = " + currentState + " currentBuffer = " + m.getContent());
			return m;
		}else{
			System.out.println("No next state available");
			return null;
		}
	}

	@Override
	public boolean redoAvailable() {
		return currentState < stateList.size() -1;
	}

	@Override
	public boolean undoAvailable() {
		return currentState > 0;
	}

	

}
