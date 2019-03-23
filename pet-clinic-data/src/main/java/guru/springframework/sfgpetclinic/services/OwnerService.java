package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

import java.util.Optional;

public interface OwnerService extends CrudService<Owner, Long> {

    /**
     * Finds an owner with the input last name, ignoring case.
     *
     * The first owner found with matching surname is returned. No gaurantee is
     * made that the same owner is returned on each call.
     *
     * @param lastName the owner last name to be searched for
     * @return an owner with the last name if one exists, else absent
     */
    Optional<Owner> findByLastName(String lastName);
}
