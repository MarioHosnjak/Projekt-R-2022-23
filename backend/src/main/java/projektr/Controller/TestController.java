package projektr.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController
{
    @RequestMapping("/api/test")
    public String hello()
    {
        return "Test!";
    }
}
