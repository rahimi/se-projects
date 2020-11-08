package patterns;

import java.util.ArrayList;

public class ObserverPattern {
    public static void main(String[] args) {
        Chat messageBoard = new Chat();
        Chatter juls = new Chatter("Julian");
        Chatter lisa = new Chatter("Lisa");
        juls.participate(messageBoard);
        lisa.participate(messageBoard);
        juls.postMessage("Hi Lisa!");
        lisa.postMessage("Hi Juls!");
    }
}

class Chat {
    ArrayList<Chatter> participants = new ArrayList<>();
    void addParticipant(Chatter chatter){
        participants.add(chatter);
    }

    void postToBoard(String message){
        participants.forEach((chatter)->chatter.receiveMessage(message));
    }
}

class Chatter {
    Chat chat;
    String name;
    public Chatter(String name){
        this.name = name;
    }
    void postMessage(String message){
        chat.postToBoard("From "+name+": "+message);
    }
    void receiveMessage(String message){
        System.out.println(message+ " received @ "+name);
    }
    void participate(Chat chat){
        this.chat = chat;
        chat.addParticipant(this);
    }
}
