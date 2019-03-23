package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Optional<Owner> findByLastName(String lastName) {
        return super.findAll().stream()
                .filter(owner -> lastName.equalsIgnoreCase(owner.getLastName()))
                .findFirst();
    }
}
