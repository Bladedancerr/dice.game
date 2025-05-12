package com.lasha.dice.game.repository;

import com.lasha.dice.game.entity.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TableRepository extends JpaRepository<TableEntity, UUID>
{
    
}
