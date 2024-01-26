package Controllers;
@RestController
public class HomeControllers {
    @GetMapping("/")
    public String greetings()
    {
        return "Welcome to the animal serive!";
    }
}
