package me.seowoo.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
//    @GetMapping("/test")
//    public String test() {
//        return "Hello, world!";
//    }

    @Autowired
    TestService testService;

    @GetMapping("/test")
    public List<Member> getAllMember() {
        List<Member> members = testService.getAllMemebers();
        return members;
    }
}
