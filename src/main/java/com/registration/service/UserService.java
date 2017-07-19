package com.registration.service;

import com.registration.model.User;

public interface UserService {
    void save(User user);

    User findByEmail(String username);
}
