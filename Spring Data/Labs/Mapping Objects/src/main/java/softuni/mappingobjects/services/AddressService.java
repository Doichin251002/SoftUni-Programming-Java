package softuni.mappingobjects.services;

import softuni.mappingobjects.dto.AddressDTO;
import softuni.mappingobjects.entities.Address;

public interface AddressService {
    Address create(AddressDTO addressDTO);
}
