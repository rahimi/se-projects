package patterns;

import java.util.HashMap;

public class MementoPattern {
    public static void main(String[] args) {
        HistorizedString string = new HistorizedString();
        String stateID = string.saveState("Hallo!");
        System.out.println(string);
        string.saveState("World!");
        System.out.println(string);
        string.restoreState(stateID);
        System.out.println(string);
    }

}

class HistorizedString{
    private String state;
    private HashMap<String, Memento> savedStates = new HashMap<>();

    public String saveState(String state){
        this.state = state;
        String id = new StringBuilder().append(System.currentTimeMillis()).append(state.hashCode()).toString();
        savedStates.put(id, new Memento(state));
        return id;
    }

    public void restoreState(String state){
        this.state = savedStates.get(state).internalState;
    }

    private class Memento {
        private final String internalState;
        Memento(String internalState) {
            this.internalState = internalState;
        }
    }

    @Override
    public String toString() {
        return "HistorizedString{" +
                "state='" + state + '\'' +
                '}';
    }
}