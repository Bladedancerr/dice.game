package com.lasha.dice.game.repository;

import com.lasha.dice.game.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Integer, UserEntity>
{

}
