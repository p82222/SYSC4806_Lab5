package Lab4_SpringMVC;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AddressBookControllerTest {

    @Autowired
    private AddressBookController addressBookController;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;



    @Test
    public void contextLoads() throws Exception {
        assertThat(addressBookController).isNotNull();
    }

    @Test
    public void createAddressBookTest() throws Exception {

        ResponseEntity<AddressBook> response = restTemplate.postForEntity("http://localhost:" + port + "/addressbooks", null, AddressBook.class);
        Assertions.assertEquals(200, response.getStatusCode().value());

        AddressBook createAB = response.getBody();
        Assertions.assertNotNull(createAB);
        Assertions.assertNotNull(createAB.getId());

        //test delete
        BuddyInfo buddy1 = new BuddyInfo("Name1", "111");
        BuddyInfo buddy2 = new BuddyInfo("Name2", "222");

        createAB.addBuddy(buddy1);
        createAB.addBuddy(buddy2);
        Assertions.assertEquals(2,createAB.getBuddyList().size());





    }

    @Test
    public void editAddressBookTest() throws Exception {

        ResponseEntity<AddressBook> response = restTemplate.postForEntity("http://localhost:" + port + "/addressbooks", null, AddressBook.class);
        Assertions.assertEquals(200, response.getStatusCode().value());

        AddressBook createAB = response.getBody();
        Assertions.assertNotNull(createAB);
        Assertions.assertNotNull(createAB.getId());

        //test delete
        BuddyInfo buddy1 = new BuddyInfo("Name1", "111");
        BuddyInfo buddy2 = new BuddyInfo("Name2", "222");

        createAB.addBuddy(buddy1);
        createAB.addBuddy(buddy2);
        Assertions.assertEquals(2,createAB.getBuddyList().size());

        createAB.removeBuddy(buddy2);
        Assertions.assertEquals(1,createAB.getBuddyList().size());


    }

    @Test
    public void deleteAddressBookTest() throws Exception {

        ResponseEntity<AddressBook> response = restTemplate.postForEntity("http://localhost:" + port + "/addressbooks", null, AddressBook.class);
        Assertions.assertEquals(200, response.getStatusCode().value());

        AddressBook createAB = response.getBody();
        Assertions.assertNotNull(createAB);
        Assertions.assertNotNull(createAB.getId());



        addressBookController.deleteAddressBook(createAB.getId());

        Assertions.assertEquals(0,addressBookController.getAllAddressBooks().size());

    }










}
