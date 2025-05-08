package com.lasha.dice.game.repository;

import com.lasha.dice.game.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>
{
    @Query(value = "SELECT u FROM UserEntity u WHERE u.username = ?1")
    public Optional<UserEntity> findByUsername(String username);
}
