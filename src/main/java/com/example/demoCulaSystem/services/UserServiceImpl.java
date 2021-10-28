package com.example.demoCulaSystem.services;

import com.example.demoCulaSystem.exceptions.UserException;
import com.example.demoCulaSystem.model.Category;
import com.example.demoCulaSystem.model.Task;
import com.example.demoCulaSystem.model.User;
import com.example.demoCulaSystem.repos.TaskRepository;
import com.example.demoCulaSystem.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Override
    public User createUser(User user) throws UserException {
      try{
           if (!userRepository.existsByEmail(user.getEmail())){
               throw new UserException("sorry, this email is already exist");
           } else {
               userRepository.save(user);
           }
          }catch(Exception e){
          throw new UserException("can not create null user");
        }
    return user;
    }

    @Override
    public void updateUser(User user) throws UserException {
        try {
            if (!userRepository.existsByEmail(user.getEmail())) {
                throw new UserException("sorry, this email is already exist");
            }
            userRepository.saveAndFlush(user);
        } catch (Exception e) {
            throw new UserException("can not update null user");
        }
    }
        @Override
        public void deleteUser (Long id) throws UserException {
            if (!userRepository.existsById(id)) {
                throw new UserException("this user doesn't exists");
            }
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() throws UserException {
        if (userRepository.findAll().isEmpty()) {
            throw new UserException("sorry, no users to show yet");
        }
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public List<User> getUsersByCategory(Category interest) throws UserException{
        if (userRepository.getUsersByInterest(interest).isEmpty()) {
            throw new UserException("sorry, no category to show");
        }
        return userRepository.getUsersByInterest(interest);
    }

    @Override
    public List<User> getUsersByTasks(Long taskId) throws UserException{
        Task task = taskRepository.getOne(taskId);
        List<User> userList = task.getTeam();
        if (userList.isEmpty()) {
            throw new UserException("sorry, no tasks to show");
        }
        return userList;
    }
}
