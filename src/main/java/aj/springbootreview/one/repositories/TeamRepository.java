package aj.springbootreview.one.repositories;

import aj.springbootreview.one.entities.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends CrudRepository<Team, String> {
    Optional<Team> findByName(String name);
    Optional<Team> findById(String id);
}
