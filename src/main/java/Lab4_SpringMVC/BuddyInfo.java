package Lab4_SpringMVC;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;

@Entity
@Service
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNum;

    @ManyToOne
    private AddressBook ab;

    /**
     * Constructor for the BuddyInfo class
     * @param name The name for the buddy
     * @param phoneNum The phone number for the buddy
     */
    public BuddyInfo(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    // Default constructor (satisfy JPA)
    public BuddyInfo() {}

    public void setAddressBook(AddressBook addressBook){
        if(this.ab != null){
            this.ab.removeBuddy(this);
        }
        this.ab = addressBook;
    }

    @Override
    public String toString() {
        return String.format(
                "Buddy[id=%d, firstName='%s', phoneNumber='%s']",
                id, name, phoneNum);
    }

    /**
     * A getter for the name of the buddy
     * @return The name of the buddy as a string
     */
    public String getName() {
        return name;
    }

    /**
     * A setter for the name of the buddy
     * @param name The name for the buddy
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * A getter for the phone number of the buddy
     * @return The phone number for the buddy as a string
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * A setter for the phone number of the buddy
     * @param phoneNum The phone number for the buddy
     */
    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }

    /**
     * A setter for the buddy id
     * @param id The id associated with a buddy
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * A getter for the buddy id
     * @return The buddy id
     */
    public Long getId() {
        return id;
    }
}
