public interface AppointmentType {
    void configureAppointment(String patientName, String doctorName, String dateTime);
    double calculateCost();
    void sendNotification(String patientContact, String dateTime);
    boolean cancelAppointment(String status);
    String generateDocumentation();
    void postAppointmentActions(String patientName);
}
