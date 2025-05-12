package com.lasha.dice.game.dto;


import com.lasha.dice.game.enums.Enums;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.UUID;

public class CreateTableRequestDto
{
    private UUID id;

    private UUID hostId;
    private UUID guestId;

    @Enumerated(EnumType.STRING)
    private Enums.TableStatus status;

    public CreateTableRequestDto(UUID id, UUID hostId, UUID guestId, Enums.TableStatus status)
    {
        this.id = id;
        this.hostId = hostId;
        this.guestId = guestId;
        this.status = status;
    }

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }

    public UUID getHostId()
    {
        return hostId;
    }

    public void setHostId(UUID hostId)
    {
        this.hostId = hostId;
    }

    public UUID getGuestId()
    {
        return guestId;
    }

    public void setGuestId(UUID guestId)
    {
        this.guestId = guestId;
    }

    public Enums.TableStatus getStatus()
    {
        return status;
    }

    public void setStatus(Enums.TableStatus status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "CreateTableRequestDto{" +
                "id=" + id +
                ", hostId=" + hostId +
                ", guestId=" + guestId +
                ", status=" + status +
                '}';
    }
}
