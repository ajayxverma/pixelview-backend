package com.airexus.pixelview.repositories;

import com.airexus.pixelview.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, Long> {

    /**
     * Finds a user by their username.
     *
     * @param username the username of the user
     * @return the user with the specified username, or null if not found
     */
    User findByUsername(String username);

}
