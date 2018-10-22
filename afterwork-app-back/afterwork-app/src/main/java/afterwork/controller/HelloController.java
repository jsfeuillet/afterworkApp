package afterwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import afterwork.dto.HelloDTO;
import afterwork.services.interfaces.IHelloService;

@RestController
public class HelloController {
	
	@Autowired
    IHelloService helloService;
    
    @RequestMapping("/hello")
    public HelloDTO sayHello(@RequestParam(value="name", defaultValue="World") String name) {
        return helloService.sayHello();
    }
}