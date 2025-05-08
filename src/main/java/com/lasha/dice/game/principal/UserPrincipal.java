package com.lasha.dice.game.principal;

import com.lasha.dice.game.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails
{
    private final UserEntity userEntity;

    public UserPrincipal(UserEntity userEntity)
    {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return List.of();
    }

    @Override
    public String getPassword()
    {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername()
    {
        return userEntity.getUsername();
    }
}
