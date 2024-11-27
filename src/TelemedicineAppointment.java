public class TelemedicineAppointment implements AppointmentType {
    @Override
    public void configureAppointment(String patientName, String doctorName, String dateTime) {
        System.out.println("Consulta de telemedicina configurada:");
        System.out.println("Link gerado e enviado para o paciente.");
    }

    @Override
    public double calculateCost() {
        return 150.0; // Taxa reduzida para telemedicina
    }

    @Override
    public void sendNotification(String patientContact, String dateTime) {
        System.out.println("Notificação enviada para " + patientContact +
                ": 'Lembrete: sua consulta de telemedicina será às " + dateTime +
                ". O link foi enviado por e-mail.'");
    }

    @Override
    public boolean cancelAppointment(String status) {
        if (status.equals("Scheduled")) {
            System.out.println("Consulta de telemedicina cancelada com sucesso.");
            return true;
        }
        System.out.println("Cancelamento não permitido para status: " + status);
        return false;
    }

    @Override
    public String generateDocumentation() {
        return "Relatório enviado por e-mail ao paciente.";
    }

    @Override
    public void postAppointmentActions(String patientName) {
        System.out.println("Receita digital enviada para o paciente " + patientName + ".");
    }
}
