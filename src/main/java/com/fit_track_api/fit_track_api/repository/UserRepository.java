<<<<<<< HEAD:src/main/java/com/fitness_track_api/fitness_track/repository/UserRepository.java
package com.fitness_track_api.fitness_track.repository;
import com.fitness_track_api.fitness_track.model.User;
=======
package com.fit_track_api.fit_track_api.repository;
import com.fit_track_api.fit_track_api.model.User;
>>>>>>> origin/nipuna:src/main/java/com/fit_track_api/fit_track_api/repository/UserRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    List<User> findByFollowingContaining(User user);
    List<User> findByFollowersContaining(User user);
    // Add this line:
    boolean existsByEmail(String email);

    // You might also want to add:
    boolean existsByUsername(String username);
}