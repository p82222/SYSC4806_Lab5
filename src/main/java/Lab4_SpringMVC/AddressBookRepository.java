package Lab4_SpringMVC;

import Lab4_SpringMVC.AddressBook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
    @Query("SELECT DISTINCT ab FROM AddressBook ab LEFT JOIN FETCH ab.buddyList WHERE ab.id = :addressBookId")
    AddressBook findByIdWithBuddies(@Param("addressBookId") Long addressBookId);

    Optional<AddressBook> findById(Long id);
}
