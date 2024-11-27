import java.time.LocalDateTime;
import java.util.List;

public class SecretaryAppointment extends Appointment {
    public SecretaryAppointment(AppointmentType appointmentType) {
        super(appointmentType);
    }

    @Override
    public void scheduleAppointment(Patient patient, Medic medic, LocalDateTime dateTime) {
        System.out.println("Secretário agendando consulta:");

        // Configurar atributos na classe base usando os objetos Patient e Medic
        this.setPatientId(patient.getId());
        this.setMedicId(medic.getId());
        this.setDateHour(dateTime);
        this.setStatus("Scheduled"); // Definindo o status como "Scheduled"

        // Delegar ao tipo de consulta
        appointmentType.configureAppointment(patient.getName(), medic.getName(), dateTime.toString());

        // Enviar notificação para o paciente
        appointmentType.sendNotification(patient.getEmail(), dateTime.toString());

        System.out.println("Consulta agendada pelo secretário para o paciente: " + patient.getName());
    }

    public void rescheduleAppointment(Patient patient, Medic medic, String oldDateTime, LocalDateTime newDateTime) {
        System.out.println("Secretário reagendando consulta:");
        System.out.println("Consulta de " + oldDateTime + " foi alterada para " + newDateTime);

        // Atualizar atributos usando os objetos Patient e Medic
        this.setPatientId(patient.getId());
        this.setMedicId(medic.getId());
        this.setDateHour(newDateTime);
        this.setStatus("Rescheduled"); // Atualizando o status para "Rescheduled"

        // Delegar ao tipo de consulta
        appointmentType.configureAppointment(patient.getName(), medic.getName(), newDateTime.toString());
        appointmentType.sendNotification(patient.getEmail(), newDateTime.toString());
    }

    public void viewFullCalendar(List<Appointment> appointments) {
        System.out.println("Agenda completa:");
        for (Appointment appointment : appointments) {
            System.out.println("Paciente ID: " + appointment.getPatientId() +
                    ", Médico ID: " + appointment.getMedicId() +
                    ", Data: " + appointment.getDateHour() +
                    ", Status: " + appointment.getStatus());
        }
    }

    public void generatePatientReport(Patient patient) {
        System.out.println("Secretário gerando relatório para o paciente " + patient.getName());
        String documentation = appointmentType.generateDocumentation();
        System.out.println("Documentos gerados: " + documentation);
    }
}
