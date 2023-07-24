package softuni.mappingobjects.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.mappingobjects.dto.AddressDTO;
import softuni.mappingobjects.entities.Address;
import softuni.mappingobjects.repositories.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;

    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address create(AddressDTO addressDTO) {
        ModelMapper mapper = new ModelMapper();

        Address address = mapper.map(addressDTO, Address.class);

        return repository.save(address);
    }
}
