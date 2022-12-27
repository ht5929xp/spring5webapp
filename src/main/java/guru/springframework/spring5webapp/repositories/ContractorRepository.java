package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Contractor;
import org.springframework.data.repository.CrudRepository;

public interface ContractorRepository extends CrudRepository<Contractor, Long> {
}
