package com.lasha.dice.game.repository;

import com.lasha.dice.game.entity.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TableRepository extends JpaRepository<TableEntity, UUID>
{
    @Query("SELECT t FROM TableEntity t WHERE t.status = com.lasha.dice.game.enums.Enums.TableStatus.AVAILABLE AND t.host.id != ?1")
    List<TableEntity> getAvailableTables(UUID userId);
}
