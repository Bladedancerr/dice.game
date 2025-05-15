package com.lasha.dice.game.dto.user;

import java.util.UUID;

public class UserDto
{
    private UUID id;
    private String username;
    private String email;
    private String phoneNumber;
    private int winStreak;
    private int gamesPlayed;
    private int avatarId;

    public UserDto()
    {
    }

    public UserDto(UUID id, String username, String email, String phoneNumber, int winStreak, int avatarId)
    {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.winStreak = winStreak;
        this.avatarId = avatarId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
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

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
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

    @Override
    public String toString()
    {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", winStreak=" + winStreak +
                ", gamesPlayed=" + gamesPlayed +
                ", avatarId=" + avatarId +
                '}';
    }
}
