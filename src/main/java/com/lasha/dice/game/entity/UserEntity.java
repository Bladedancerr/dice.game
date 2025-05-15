package com.lasha.dice.game.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity
{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private Date createdAt;
    private int winStreak;
    private int gamesPlayed;
    private int avatarId;

    public UserEntity()
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

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public int getWinStreak()
    {
        return winStreak;
    }

    public void setWinStreak(int winStreak)
    {
        this.winStreak = winStreak;
    }

    public int getAvatarId()
    {
        return avatarId;
    }

    public void setAvatarId(int avatarId)
    {
        this.avatarId = avatarId;
    }

    public int getGamesPlayed()
    {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed)
    {
        this.gamesPlayed = gamesPlayed;
    }

    public boolean isValid()
    {
        return username != null && !username.isEmpty() &&
               password != null && !password.isEmpty() &&
               email != null && !email.isEmpty() &&
               phoneNumber != null && !phoneNumber.isEmpty();
    }

    @Override
    public String toString()
    {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createdAt=" + createdAt +
                ", winStreak=" + winStreak +
                ", gamesPlayed=" + gamesPlayed +
                ", avatarId=" + avatarId +
                '}';
    }
}
