package com.RickieProject.FlashCardCreater.Database;

import com.RickieProject.FlashCardCreater.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {


    @Override
    Optional<User> findById(Integer integer);

    User findByUserName(String userName);

}
