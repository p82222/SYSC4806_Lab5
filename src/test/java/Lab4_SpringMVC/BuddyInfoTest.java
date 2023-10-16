package Lab4_SpringMVC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BuddyInfoTest {

    private static BuddyInfo buddy;

    @BeforeAll
    public static void setUp(){
        buddy = new BuddyInfo("Keefer", "123-456-7890");
    }

    @Test
    public void testBuddyGetName(){
        Assertions.assertEquals("Keefer", buddy.getName());
    }

    @Test
    public void testGetPhoneNumber() {
        Assertions.assertEquals("123-456-7890", buddy.getPhoneNum());
    }
}