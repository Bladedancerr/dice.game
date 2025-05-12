package com.lasha.dice.game.repository;

import com.lasha.dice.game.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID>
{
    @Query(value = "SELECT u FROM UserEntity u WHERE u.username = ?1")
    public Optional<UserEntity> findByUsername(String username);
}
