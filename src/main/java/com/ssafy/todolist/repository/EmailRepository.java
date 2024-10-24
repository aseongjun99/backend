package com.ssafy.todolist.repository;

import com.ssafy.todolist.domain.email.Email;
import com.ssafy.todolist.domain.email.EmailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {

    Email findByEmail(String email);

}
