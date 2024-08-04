package com.example.memorycache.services;

import com.example.memorycache.entity.User;
import com.example.memorycache.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    @CachePut(value = "caffeineCache" ,key = "#user.id")
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    @Cacheable(value = "caffeineCache",key = "#id")
    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    @CachePut(value = "caffeineCache",key = "#user.id")
    public void updateUser(User user) {
repository.save(user);
    }

    @Override
    @CacheEvict(value = "caffeineCache",key = "#id")
    public void deleteUser(Long id) {
repository.deleteById(id);
    }

    @Override
    @CacheEvict(value = "caffeineCache",allEntries = true)
    public void deleteUsers() {
repository.deleteAll();
    }
}
