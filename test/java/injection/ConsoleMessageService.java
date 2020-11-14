package injection;

import org.springframework.stereotype.Component;

@Component("console")
public class ConsoleMessageService implements MessageService {
    @Override
    public void send(String message) {
        System.out.println(message);
    }
}
