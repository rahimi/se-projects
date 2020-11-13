import injection.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@Component
@SpringJUnitConfig(InjectionConfig.class)
public class InjectionTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void injectionFileTest(){
        MessageService service = context.getBean("file",MessageService.class);
        service.send("Test"+System.currentTimeMillis());
        /*appropriate test code here*/
    }

    @Test
    public void injectionConsoleTest(){
        MessageService service = context.getBean("console",MessageService.class);
        service.send("Test");
        /*appropriate test code here*/
    }

    @Test
    public void mockedServiceTest(){
        MessageService service = Mockito.mock(MessageService.class);
        Mockito.doAnswer((invocation)-> {System.out.println(invocation);return null;}).when(service).send("Hello!");
        service.send("Hello!");
    }
}
