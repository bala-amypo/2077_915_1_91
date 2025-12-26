@RestController
@RequestMapping("/api/tickets")
@Tag(name = "Ticket Controller", description = "Ticket management APIs")
public class TicketController {

    @PostMapping
    public String createTicket() {
        return "Ticket created";
    }

    @GetMapping
    public String listTickets() {
        return "All tickets";
    }

    @GetMapping("/{id}")
    public String getTicket(@PathVariable Long id) {
        return "Ticket " + id;
    }
}
