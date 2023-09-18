package softuni.mappingobjects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.mappingobjects.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
