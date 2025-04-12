package modelo;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear roles
        Roles rolAdmin = new Roles("Administrador");
        Roles rolTecnico = new Roles("Tecnico");

        Administrador admin = new Administrador("Alan Perez", "Alpe@gmail.com", rolAdmin);
        Tecnico tecnico = new Tecnico("Maria Lopez", "maria@hotmail.com", rolTecnico);

        // Mostrar informacion de los usuarios
        admin.mostrarInfo();
        tecnico.mostrarInfo();

        // Crear un departamento y asignar al tecnico
        Departamento departamento = new Departamento("Soporte");
        departamento.asignarTecnico(tecnico);

        // Crear un ticket en el que el administrador es el solicitante y se asigna el ticket al tecnico
        Ticket ticket = new Ticket("Error de conexion", "No se puede conectar a la base de datos.", admin, tecnico);
        System.out.println("Ticket creado con ID: " + ticket.getId());
        System.out.println("Estado inicial del ticket: " + ticket.getEstado().getNombre());

        // Agregar una nota al ticket
        Nota nota = new Nota("Se reviso la configuracion de red y se reinicio el servidor.");
        ticket.agregarNota(nota);

        // Cambiar el estado del ticket de 'Abierto' a 'En Proceso' y luego a 'Cerrado'
        ticket.cambiarEstado("En Proceso");
        System.out.println("Estado del ticket tras cambio: " + ticket.getEstado().getNombre());

        ticket.cambiarEstado("Cerrado");
        System.out.println("Estado final del ticket: " + ticket.getEstado().getNombre());

        // Simular la finalizacion del ticket con la fecha de finalizacion (opcional)
        // Ejemplo: ticket.setFechaFinalizacion(LocalDate.now());
        System.out.println("Fecha de creacion: " + ticket.getFechaCreacion());
    }
}
