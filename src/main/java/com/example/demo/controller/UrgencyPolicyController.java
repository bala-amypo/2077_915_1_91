@RestController
@RequestMapping("/api/policies")
@Tag(name = "Urgency Policy Controller", description = "Urgency policy APIs")
public class UrgencyPolicyController {

    @PostMapping
    public String createPolicy() {
        return "Policy created";
    }

    @GetMapping
    public String listPolicies() {
        return "All policies";
    }

    @GetMapping("/{id}")
    public String getPolicy(@PathVariable Long id) {
        return "Policy " + id;
    }
}
