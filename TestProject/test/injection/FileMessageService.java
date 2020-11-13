package injection;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;

@Component("file")
public class FileMessageService implements MessageService {
    @Override
    public void send(String message) {
        File f = new File(System.getProperty("user.dir") + "/TestProject/test/injection/messages.txt");
        try{
            if(!f.exists())
                f.createNewFile();
            FileWriter fw = new FileWriter(f,true);
            fw.write(message+"\n");
            fw.flush();
            fw.close();
        }catch (Exception e){
            System.out.println("Could not create file "+e);
        }

    }
}
