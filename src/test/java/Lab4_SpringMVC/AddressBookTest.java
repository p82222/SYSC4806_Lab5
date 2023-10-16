package Lab4_SpringMVC;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddressBookTest {

    @Test
    public void testAddRemoveBuddy() {
        AddressBook addressBook = new AddressBook();

        BuddyInfo buddy1 = new BuddyInfo("John", "123-456-7890");
        BuddyInfo buddy2 = new BuddyInfo("Alice", "987-654-3210");

        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);

        Assertions.assertEquals(2, addressBook.getBuddyList().size());

        addressBook.removeBuddy(buddy1);

        Assertions.assertEquals(1, addressBook.getBuddyList().size());
    }
}