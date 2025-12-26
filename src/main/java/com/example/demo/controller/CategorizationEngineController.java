@RestController
@RequestMapping("/api/categorize")
@Tag(name = "Categorization Engine Controller", description = "Ticket categorization APIs")
public class CategorizationEngineController {

    @PostMapping("/run/{ticketId}")
    public String categorize(@PathVariable Long ticketId) {
        return "Ticket categorized " + ticketId;
    }

    @GetMapping("/logs/{ticketId}")
    public String listLogs(@PathVariable Long ticketId) {
        return "Logs for ticket " + ticketId;
    }

    @GetMapping("/log/{id}")
    public String getLog(@PathVariable Long id) {
        return "Log " + id;
    }
}
