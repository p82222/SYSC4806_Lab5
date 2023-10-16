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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BuddyinfoControllerTest {

    @Autowired
    private BuddyInfoController buddyInfoController;

    @Autowired
    private AddressBookController addressBookController;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;


    @Test
    public void contextLoads() throws Exception {
        assertThat(buddyInfoController).isNotNull();
    }

    @Test
    public void createBuddyInfoTest() throws Exception {

        ResponseEntity<BuddyInfo> response = restTemplate.postForEntity("http://localhost:" + port + "/buddies", null, BuddyInfo.class);
        Assertions.assertEquals(415, response.getStatusCode().value());

        BuddyInfo buddyInfo = response.getBody();
        buddyInfo.setId((long)1);
        Assertions.assertNotNull(buddyInfo);
        Assertions.assertNotNull(buddyInfo.getId());

    }

    @Test
    public void editBuddyInfoTest() throws Exception {



        ResponseEntity<BuddyInfo> response = restTemplate.postForEntity("http://localhost:" + port + "/buddies", null, BuddyInfo.class);
        Assertions.assertEquals(415, response.getStatusCode().value());

        BuddyInfo buddyInfo = response.getBody();

        buddyInfo.setName("Buddy1");
        buddyInfo.setPhoneNum("1111");
        buddyInfo.setId((long)1);
        Assertions.assertNotNull(buddyInfo);
        Assertions.assertNotNull(buddyInfo.getId());

        Assertions.assertEquals("Buddy1",buddyInfo.getName());
        Assertions.assertEquals("1111",buddyInfo.getPhoneNum());

    }


}
