package Lab4_SpringMVC;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/addressbooks")
public class AddressBookController {

    @Autowired
    private final AddressBookRepository addressBookRepository;

    public AddressBookController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping
    public List<AddressBook> getAllAddressBooks(){
        return (List<AddressBook>) addressBookRepository.findAll();
    }

    @GetMapping("/{id}/buddies")
    public String showBuddyList(@PathVariable Long id, Model model){
        AddressBook ab = addressBookRepository.findByIdWithBuddies(id);
        model.addAttribute("buddies", ab.getBuddyList());
        return "buddies";
    }

    @PostMapping
    @ResponseBody
    public AddressBook createAddressBook(){
        AddressBook ab = new AddressBook();
        return addressBookRepository.save(ab);
    }

    @DeleteMapping("/{id}")
    public void deleteAddressBook(@PathVariable Long id) {
        addressBookRepository.deleteById(id);
    }
}
