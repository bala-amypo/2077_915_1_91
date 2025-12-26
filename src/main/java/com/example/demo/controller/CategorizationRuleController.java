@RestController
@RequestMapping("/api/rules")
@Tag(name = "Categorization Rule Controller", description = "Rule APIs")
public class CategorizationRuleController {

    @PostMapping("/{categoryId}")
    public String createRule(@PathVariable Long categoryId) {
        return "Rule created for category " + categoryId;
    }

    @GetMapping("/category/{categoryId}")
    public String listRules(@PathVariable Long categoryId) {
        return "Rules for category " + categoryId;
    }

    @GetMapping("/{id}")
    public String getRule(@PathVariable Long id) {
        return "Rule " + id;
    }
}
