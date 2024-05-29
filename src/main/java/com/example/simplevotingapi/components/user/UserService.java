package com.example.simplevotingapi.components.user;

import com.example.simplevotingapi.components.user.output.User;
import com.example.simplevotingapi.components.user.output.UserToUserEntityMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository entityRepository;

    private final UserEntityToUserMapper entityToUserMapper;
    private final UserToUserEntityMapper userToEntityMapper;

    public List<User> getAllUsers() {
        return entityToUserMapper.convert(entityRepository.findAll());
    }

    public User getUserById(Long id) {
        return entityToUserMapper.convert(entityRepository.findById(id)
                                                          .orElseThrow());
    }

    public User addUser(User user) {
        return entityToUserMapper.convert(entityRepository.save(userToEntityMapper.convert(user)));
    }

    public User getUserByUsername(String username) {
        return entityToUserMapper.convert(entityRepository.findByUsername(username)
                                                          .orElseThrow());
    }
}
