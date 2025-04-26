package modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    // Crear un ticket
    public void crearTicket(Ticket ticket) throws SQLException {
        String sql = "INSERT INTO tickets (titulo, descripcion, estado_id, solicitante_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, ticket.getTitulo());
            stmt.setString(2, ticket.getDescripcion());
            stmt.setInt(3, 1); // Estado "Abierto" por defecto
            stmt.setInt(4, ticket.getSolicitante().getId());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    ticket.setId(rs.getInt(1)); // Asigna el ID generado
                }
            }
        }
    }

    // Obtener todos los tickets
    public List<Ticket> obtenerTodos() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM tickets";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Ticket ticket = new Ticket(
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        obtenerUsuarioPorId(rs.getInt("solicitante_id")),
                        null // Asignar técnico si es necesario
                );
                ticket.setId(rs.getInt("id"));
                tickets.add(ticket);
            }
        }
        return tickets;
    }
}