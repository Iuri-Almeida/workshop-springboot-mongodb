package br.com.ialmeida.workshopmongodb.services;

import br.com.ialmeida.workshopmongodb.domain.User;
import br.com.ialmeida.workshopmongodb.dto.UserDTO;
import br.com.ialmeida.workshopmongodb.repositories.UserRepository;
import br.com.ialmeida.workshopmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found. Id " + id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(String id, User user) {
        User entity = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found. Id " + id));
        updateData(entity, user);
        return userRepository.save(entity);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
    }

}
