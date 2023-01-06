package aj.springbootreview.one.services;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    public String greet() {
        return "Hello, World!";
    }
}
