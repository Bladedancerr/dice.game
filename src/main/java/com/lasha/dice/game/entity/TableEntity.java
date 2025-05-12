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
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "host_id", nullable = false)
    private UserEntity host;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id")
    private UserEntity guest;

    @Column(name = "host_username", nullable = false)
    private String hostUsername;

    @Column(name = "guest_username", nullable = true)
    private String guestUsername;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Enums.TableStatus status;

    public TableEntity()
    {
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

    public String getHostUsername()
    {
        return hostUsername;
    }

    public void setHostUsername(String hostUsername)
    {
        this.hostUsername = hostUsername;
    }

    public String getGuestUsername()
    {
        return guestUsername;
    }

    public void setGuestUsername(String guestUsername)
    {
        this.guestUsername = guestUsername;
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
