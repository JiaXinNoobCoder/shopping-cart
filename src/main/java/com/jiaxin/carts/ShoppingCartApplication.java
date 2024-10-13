package com.jiaxin.carts;

import com.jiaxin.carts.dao.UserRepository;
import com.jiaxin.carts.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.NoSuchElementException;

@SpringBootApplication
@EnableJpaRepositories
public class ShoppingCartApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository repository) {
        return args -> {
            User user = new User();
            user.setUserID(1);
            User saved = repository.findUserByUserID(user.getUserID()).orElseThrow(NoSuchElementException::new);
            System.out.print("user:"+saved.getUserName());
        };
    }

}
