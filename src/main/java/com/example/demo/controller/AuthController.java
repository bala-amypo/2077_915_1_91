@RestController
@RequestMapping("/auth")
@Tag(name = "Auth Controller", description = "User authentication APIs")
public class AuthController {

    @PostMapping("/register")
    public String register() {
        return "User registered";
    }

    @PostMapping("/login")
    public String login() {
        return "User logged in";
    }
}
