package com.letsconnecot.service;

import com.letsconnecot.dto.LoginDto;

public interface LoginService<T> {

    public T login(LoginDto loginDto);

}
