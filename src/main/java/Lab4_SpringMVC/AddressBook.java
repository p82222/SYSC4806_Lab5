package Lab4_SpringMVC;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Entity
@Service
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressbook_seq")
    @SequenceGenerator(name = "addressbook_seq", sequenceName = "addressbook_sequence", allocationSize = 1)
    private Long id;

    @OneToMany(mappedBy = "ab", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BuddyInfo> buddyList;

    /**
     * Constructor for the AddressBook
     */
    public AddressBook() {
        buddyList = new ArrayList<>();
    }

    /**
     * Adds a BuddyInfo object to the AddressBook List
     * @param buddy The BuddyInfo object that is added
     */
    public void addBuddy(BuddyInfo buddy){
        buddyList.add(buddy);
    }

    /**
     * Removes a BuddyInfo object from the AddressBook List
     * @param buddy The BuddyInfo object that is removed
     */
    public void removeBuddy(BuddyInfo buddy){
        buddyList.remove(buddy);
    }

    /**
     * A getter for the buddyList
     * @return A list of BuddyInfo objects
     */
    public List<BuddyInfo> getBuddyList(){
        return buddyList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
