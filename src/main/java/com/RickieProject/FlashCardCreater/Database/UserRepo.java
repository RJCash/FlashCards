package com.RickieProject.FlashCardCreater.Database;

import com.RickieProject.FlashCardCreater.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByusername(String username);


    @Override
    Optional<User> findById(Integer idUser);


}
