import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Appointment {
    private int id; // Identificador único
    private int patientId; // Relacionado ao paciente
    private int medicId; // Relacionado ao médico
    private LocalDateTime dateHour; // Data e hora da consulta
    private String status; // Status da consulta (Scheduled, Cancelled, etc.)

    protected AppointmentType appointmentType;

    public Appointment(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getMedicId() {
        return medicId;
    }

    public void setMedicId(int medicId) {
        this.medicId = medicId;
    }

    public LocalDateTime getDateHour() {
        return dateHour;
    }

    public void setDateHour(LocalDateTime dateHour) {
        this.dateHour = dateHour;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", medicId=" + medicId +
                ", dateHour='" + dateHour + '\'' +
                ", status='" + status + '\'' +
                ", appointmentType=" + appointmentType +
                '}';
    }

    // Método abstrato para agendamento
    public abstract void scheduleAppointment(Patient patient, Medic medic, LocalDateTime dateTime);

    // Novo método para detalhar uma consulta
    public String getDetails() {
        return "Consulta ID: " + id + ", Paciente ID: " + patientId + ", Médico ID: " + medicId +
                ", Data e Hora: " + dateHour.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                ", Status: " + status;
    }
}
