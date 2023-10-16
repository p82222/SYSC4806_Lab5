package Lab4_SpringMVC;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    void deleteById(Long id);

    Optional<BuddyInfo> findById(Long id);
}
