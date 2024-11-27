public class InPersonAppointment implements AppointmentType {
    @Override
    public void configureAppointment(String patientName, String doctorName, String dateTime) {
        System.out.println("Consulta presencial configurada:");
        System.out.println("Sala reservada. Localização enviada: Rua da Saúde, 123, Sala 101.");
    }

    @Override
    public double calculateCost() {
        return 200.0; // Taxa fixa para consulta presencial
    }

    @Override
    public void sendNotification(String patientContact, String dateTime) {
        System.out.println("Notificação enviada para " + patientContact +
                ": 'Lembrete: sua consulta presencial será às " + dateTime +
                " na Rua da Saúde, 123, Sala 101.'");
    }

    @Override
    public boolean cancelAppointment(String status) {
        if (status.equals("Scheduled")) {
            System.out.println("Consulta presencial cancelada com sucesso.");
            return true;
        }
        System.out.println("Cancelamento não permitido para status: " + status);
        return false;
    }

    @Override
    public String generateDocumentation() {
        return "Relatório entregue fisicamente na clínica.";
    }

    @Override
    public void postAppointmentActions(String patientName) {
        System.out.println("Paciente " + patientName + " foi redirecionado para exames.");
    }

}
