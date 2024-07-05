
import model.*;
import service.*;

public class Demo {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        PlanetService planetService = new PlanetService();
        ClientService clientService = new ClientService();
//        Ticket ticket = Ticket.builder()
//                .createdAt(Timestamp.valueOf(LocalDateTime.now()))
//                .fromPlanet(planetService.findById("EARTH"))
//                .toPlanet(planetService.findById("MARS"))
//                .client(clientService.findById(3L))
//                .build();
//        ticketService.save(ticket);
//        ticketService.update(11L, clientService.findById(7L), planetService.findById("VENUS"), planetService.findById("SATURN"));
        Ticket ticket = ticketService.findById(11L);
        ticketService.delete(ticket);
    }
}
