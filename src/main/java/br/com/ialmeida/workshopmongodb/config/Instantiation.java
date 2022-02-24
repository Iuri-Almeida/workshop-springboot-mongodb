package br.com.ialmeida.workshopmongodb.config;

import br.com.ialmeida.workshopmongodb.domain.User;
import br.com.ialmeida.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User u1 = new User(null, "Maria Brown", "maria@gmail.com");
        User u2 = new User(null, "Alex Green", "alex@gmail.com");
        User u3 = new User(null, "Bob Gray", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

    }
}
