import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class FirstTest {

    public FirstTest(){
        System.out.println("Constructor");
    }

    @Test
    public void testAdd(){
        assertEquals(2,Integer.sum(1,1));
    }

    @Test
    public void testFail(){
        assertEquals(1,Integer.toString(1));
    }

    @Test
    public void testTimeout() throws InterruptedException {
        assertTimeout(Duration.ofMillis(100),()->Thread.sleep(80));
    }

    @Test
    public void testThrows(){
        assertThrows(NullPointerException.class,()->{throw new NullPointerException();});
    }

    @Test
    public void testLists(){
        List<String> list1 = List.of("1","2","3");
        List<String> list2 = List.of("1","2","3");
        assertIterableEquals(list1,list2);
    }

    @Test
    public void testWithMessage(){
        assertEquals(1,2,()->"what a day!");
    }

    @Test
    public void testGroupAssert(){
        assertAll("All the rainbows",
                ()->assertEquals("green","green"),
                ()->assertEquals("red","red"),
                ()->assertEquals("blue","blues"));
    }

    @BeforeEach
    public void runBeforeEachTest(){
        System.out.println("before each test!");
    }

    @AfterEach
    public void runAfterEachTest(){
        System.out.println("after each test!");
    }

    @BeforeAll
    public static void runBeforeOnce(){
        System.out.println("before all test!");
    }

    @AfterAll
    public static void runAfterOnce(){
        System.out.println("after all test!");
    }
}
