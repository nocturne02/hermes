package com.hermes.springboot.web;

import com.hermes.springboot.web.dto.TestResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/test/dto")
    public TestResponseDto testDto(
            @RequestParam(name = "name")String name,
            @RequestParam(name = "amount")int amount) {
        return new TestResponseDto(name, amount);
    }
}
