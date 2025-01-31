package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    Student st;
    public Hello(Student student) {
        this.st = student;
    }

    @RequestMapping("/")
    public String sayHello() {
        st.print();
        return "Hello World";
    }
}
