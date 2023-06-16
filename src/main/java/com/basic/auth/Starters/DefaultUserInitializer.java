package com.basic.auth.Starters;

import com.basic.auth.Models.Role;
import com.basic.auth.Models.User;
import com.basic.auth.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultUserInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) {
        // Verifica se o usuário padrão já existe no banco de dados
        if (!userRepository.existsByUsername("admin")) {
            // Cria um novo usuário
            User user = new User();
            user.setUsername("admin");
            // Codifica a senha antes de salvar
            user.setPassword(passwordEncoder.encode("password"));
            user.setRole(Role.ADMIN);

            // Salva o usuário no banco de dados
            userRepository.save(user);
        }
    }
}
