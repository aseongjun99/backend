package com.ssafy.todolist.service;

import com.ssafy.todolist.domain.Todo;
import com.ssafy.todolist.domain.TodoDTO;
import com.ssafy.todolist.repository.TodoRepository;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private static int number;
    private final JavaMailSender javaMailSender;

    public TodoService(TodoRepository todoRepository, JavaMailSender javaMailSender) {
        this.todoRepository = todoRepository;
        this.javaMailSender = javaMailSender;
    }

    @Transactional(readOnly = true)
    public List<TodoDTO> getTodos() {
        return todoRepository.findAll().stream().map(TodoDTO::of).toList();
    }

    @Transactional
    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Transactional
    public void deleteTodo(int todoId) {
        todoRepository.deleteById(todoId);
    }

    @Transactional
    public void updateTodo(int todoId) {
        Todo todo = todoRepository.getReferenceById(todoId);
        todo.setCompleted(!todo.getCompleted());
    }

    public MimeMessage createMail(String email) {
        number = (int) (Math.random() * (90000)) + 100000;
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom(email);
            message.setRecipients(MimeMessage.RecipientType.TO, email);
            message.setSubject("이메일 인증");
            StringBuilder body = new StringBuilder();
            body.append("<h3>요청하신 인증 번호 입니다.</h3>")
                    .append("<h1>")
                    .append(number)
                    .append("</h1>")
                    .append("<h3>감사합니다.</h3>");
            message.setText(body.toString(), "UTF-8", "html");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;
    }

    public int sendCertificationNumber(String email) {
        javaMailSender.send(createMail(email));
        return number;
    }

}
