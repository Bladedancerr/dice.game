package com.lasha.dice.game.entity;

import com.lasha.dice.game.enums.Enums;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "tables")
public class TableEntity
{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    private UserEntity host;

    @ManyToOne
    private UserEntity guest;

    @Enumerated(EnumType.STRING)
    private Enums.TableStatus status;

    public TableEntity(UUID id, UserEntity host, UserEntity guest, Enums.TableStatus status)
    {
        this.id = id;
        this.host = host;
        this.guest = guest;
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

    public UserEntity getHost()
    {
        return host;
    }

    public void setHost(UserEntity host)
    {
        this.host = host;
    }

    public UserEntity getGuest()
    {
        return guest;
    }

    public void setGuest(UserEntity guest)
    {
        this.guest = guest;
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
        return "TableEntity{" +
                "id=" + id +
                ", hostId=" + host +
                ", guestId=" + guest +
                ", status=" + status +
                '}';
    }
}
