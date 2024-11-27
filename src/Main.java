import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Lista de consultas
        List<Appointment> appointments = new ArrayList<>();

        // Criando pacientes, médicos e tipos de consulta
        Patient patient1 = new Patient(1, "João", "joao@example.com");
        Patient patient2 = new Patient(2, "Maria", "maria@example.com");

        Medic medic1 = new Medic(101, "Dr. Silva", "Cardiologia");
        Medic medic2 = new Medic(102, "Dr. Santos", "Dermatologia");

        AppointmentType inPerson = new InPersonAppointment();
        AppointmentType telemedicine = new TelemedicineAppointment();

        // Agendamento de consulta presencial para João
        PatientAppointment patientAppointment1 = new PatientAppointment(inPerson);
        LocalDateTime dateTime1 = LocalDateTime.parse("2024-11-30T10:00:00");
        patientAppointment1.scheduleAppointment(patient1, medic1, dateTime1);
        appointments.add(patientAppointment1);

        System.out.println("\n----------------------------------------------------------\n");

        // Agendamento de telemedicina para Maria
        SecretaryAppointment secretaryAppointment1 = new SecretaryAppointment(telemedicine);
        LocalDateTime dateTime2 = LocalDateTime.parse("2024-12-01T14:00:00");
        secretaryAppointment1.scheduleAppointment(patient2, medic2, dateTime2);
        appointments.add(secretaryAppointment1);

        // Visualizando consultas de João
        System.out.println("\nVisualizando consultas do paciente João:");
        patientAppointment1.viewAppointments(patient1, appointments);

        // Reagendamento da consulta de Maria
        System.out.println("\nReagendando consulta de Maria:");
        LocalDateTime newDateTime2 = LocalDateTime.parse("2024-12-02T15:00:00");
        secretaryAppointment1.rescheduleAppointment(patient2, medic2, dateTime2.toString(), newDateTime2);

        // Cancelamento da consulta de João
        System.out.println("\nCancelando consulta de João:");
        patientAppointment1.cancelAppointment(dateTime1.toString());

        // Visualizando a agenda completa
        System.out.println("\nAgenda completa:");
        secretaryAppointment1.viewFullCalendar(appointments);

        // Gerando relatório para Maria
        System.out.println("\nGerando relatório para Maria:");
        secretaryAppointment1.generatePatientReport(patient2);

        // Solicitando documentação da consulta de João
        System.out.println("\nSolicitando documentação da consulta de João:");
        patientAppointment1.requestDocumentation(patient1);

        // Exibindo os detalhes das consultas registradas
        System.out.println("\nDetalhes das consultas registradas:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment.getDetails());
        }
    }
}
