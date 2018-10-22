package afterwork.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import afterwork.dto.HelloDTO;
import afterwork.services.interfaces.IHelloService;

@Service
public class HelloService implements IHelloService {

	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

	@Override
	public HelloDTO sayHello() {
		return new HelloDTO(counter.incrementAndGet(),
                String.format(template, "Bitch"));
	}

}
