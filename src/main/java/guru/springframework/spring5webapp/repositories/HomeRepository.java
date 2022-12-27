package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Home;
import org.springframework.data.repository.CrudRepository;

public interface HomeRepository extends CrudRepository<Home, Long> {
}
