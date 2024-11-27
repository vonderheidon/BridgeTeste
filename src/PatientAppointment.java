import java.time.LocalDateTime;
import java.util.List;

public class PatientAppointment extends Appointment {
    public PatientAppointment(AppointmentType appointmentType) {
        super(appointmentType);
    }

    @Override
    public void scheduleAppointment(Patient patient, Medic medic, LocalDateTime dateTime) {
        System.out.println("Paciente agendando consulta:");

        // Configurar atributos na classe base usando os objetos Patient e Medic
        this.setPatientId(patient.getId());
        this.setMedicId(medic.getId());
        this.setDateHour(dateTime);
        this.setStatus("Scheduled"); // Definindo o status como "Scheduled"

        // Delegar ao tipo de consulta
        appointmentType.configureAppointment(patient.getName(), medic.getName(), dateTime.toString());

        // Enviar notificação para o paciente usando o e-mail do modelo
        appointmentType.sendNotification(patient.getEmail(), dateTime.toString());

        System.out.println("Agendamento realizado pelo paciente: " + patient.getName());
    }

    public boolean cancelAppointment(String dateTime) {
        System.out.println("Paciente solicitando cancelamento de consulta:");
        if (this.getStatus().equals("Scheduled") && isWithinCancellationPeriod(dateTime)) {
            this.setStatus("Cancelled"); // Atualizando o status para "Cancelled"
            System.out.println("Consulta cancelada com sucesso.");
            return true;
        }
        System.out.println("Não é possível cancelar a consulta.");
        return false;
    }

    private boolean isWithinCancellationPeriod(String dateTime) {
        // Implementação fictícia para verificar se a consulta está a mais de 24 horas do horário atual
        return true;
    }

    public void viewAppointments(Patient patient, List<Appointment> appointments) {
        System.out.println("Consultas do paciente " + patient.getName() + ":");
        for (Appointment appointment : appointments) {
            if (appointment.getPatientId() == patient.getId()) {
                System.out.println("Consulta com o médico ID: " + appointment.getMedicId() +
                        " em " + appointment.getDateHour() + " - Status: " + appointment.getStatus());
            }
        }
    }

    public void requestDocumentation(Patient patient) {
        System.out.println("Paciente " + patient.getName() + " solicitando documentos da consulta.");
        String documentation = appointmentType.generateDocumentation();
        System.out.println("Documentos gerados: " + documentation);
    }
}
