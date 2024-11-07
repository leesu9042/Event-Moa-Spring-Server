package com.example.eventmoa;

import com.example.eventmoa.global.error.ExceptionException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/error")
    public String error() {
         try{
             throw new ExceptionException();
         }catch (Exception e){
             throw new ExceptionException();
         }
    }
}
