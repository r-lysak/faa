package com.example.faa.repository;

import com.example.faa.model.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepository {
    private Map<Long, User> mapIdToUser = Map.of(
            1L, User.builder().id(1).name("Test#1").build(),
            2L, User.builder().id(2).name("Test#2").build());

    public User getUserById(long id) {
        return mapIdToUser.get(id);
    }
}
