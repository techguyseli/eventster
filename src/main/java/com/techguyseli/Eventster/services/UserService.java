package com.techguyseli.Eventster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techguyseli.Eventster.entities.User;
import com.techguyseli.Eventster.exceptions.UserNotFoundException;
import com.techguyseli.Eventster.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<User> getAllUsers() {
    return repository.findAll();
  }

  public User getUserById(Long UserId) throws UserNotFoundException {
    return repository.findById(UserId)
        .orElseThrow(() -> extracted(UserId));
  }

  private UserNotFoundException extracted(Long UserId) {
    return new UserNotFoundException(UserId);
  }

  public User createUser(User User) {
    return repository.save(User);
  }

  public User updateUser(Long UserId, User updatedUser) throws UserNotFoundException {
    User existingUser = getUserById(UserId);
    existingUser.setUsername(updatedUser.getUsername());
    existingUser.setPassword(updatedUser.getPassword());
    return repository.save(existingUser);
  }

  public void deleteUser(Long UserId) throws UserNotFoundException {
    User existingUser = getUserById(UserId);
    repository.delete(existingUser);
  }

}
