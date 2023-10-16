package Lab4_SpringMVC;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/buddies")
public class BuddyInfoController {

    @Autowired
    private final BuddyInfoRepository buddyInfoRepository;
    private final AddressBookRepository addressBookRepository;

    public BuddyInfoController(BuddyInfoRepository buddyInfoRepository, AddressBookRepository addressBookRepository) {
        this.buddyInfoRepository = buddyInfoRepository;
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping
    public List<BuddyInfo> getBuddies(){
        return (List<BuddyInfo>) buddyInfoRepository.findAll();
    }

    @PostMapping
    @ResponseBody
    public BuddyInfo addBuddy(@RequestBody BuddyInfo buddyInfo, @RequestParam Long addressBookId){
        AddressBook addressBook = addressBookRepository.findById(addressBookId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid address book ID"));

        addressBook.addBuddy(buddyInfo);
        addressBookRepository.save(addressBook);

        buddyInfo.setAddressBook(addressBook);

        return buddyInfoRepository.save(buddyInfo);
    }

    @DeleteMapping("/buddies")
    @ResponseBody
    public void deleteBuddy(@RequestParam Long addressID, @RequestParam Long id) {

        Optional<AddressBook> ab = addressBookRepository.findById(addressID);

        Optional<BuddyInfo> buddy = buddyInfoRepository.findById(id);

        ab.get().removeBuddy(buddy.get());

        addressBookRepository.save(ab.get());

//        buddyInfoRepository.deleteById(id);
    }
}
