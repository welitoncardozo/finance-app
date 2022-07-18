package com.welitoncardozo.userservice.repositories;

import com.welitoncardozo.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(final String email);

    @Query(
            " SELECT user" +
            "   FROM User user" +
            "   WHERE user.email = :email" +
            "     AND (COALESCE(:id) IS NULL OR user.id != :id)"
    )
    Optional<User> findExistsOtherWithEmail(@Param("id") final Integer id, @Param("email") final String email);
}
