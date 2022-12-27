package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}

