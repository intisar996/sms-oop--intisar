package services;

import entities.Appointment;
import interfaces.Manageable;
import utils.HelperUtils;

import java.sql.Time;
import java.util.Date;

public class AppointmentService implements Manageable {


    private Appointment[] appointments;
    private int count;

    public AppointmentService() {
        appointments = new Appointment[100];
        count = 0;
    }


    //schedule overloads (x3)
    public Appointment schedule(Long patientId, Long doctorId, Date date) {
        Time defaultTime = new Time(System.currentTimeMillis());
        Long appointmentId = HelperUtils.generateId();
        Appointment appointment = new Appointment(date,
                appointmentId,
                 defaultTime,
                false,
                doctorId,
                patientId,
                "General appointment",
                Appointment.Status.RESCHEDULE
        );
        return appointment;
    }

    public Appointment schedule(Long patientId, Long doctorId, Date date,Time time) {
        Long appointmentId = HelperUtils.generateId();
        Appointment appointment = new Appointment(date,
                appointmentId,
                time,
                false,
                doctorId,
                patientId,
                "General appointment",
                Appointment.Status.RESCHEDULE
        );
        return appointment;
    }

    public Appointment schedule(Appointment appointment,String reason) {
        if (appointment == null) {
            System.out.println("Appointment is required");
            return null;
        }
        if (appointment.getAppointmentId() == null) {
            appointment.setAppointmentId(HelperUtils.generateId());
        }
        appointment.setReason(reason);
        appointment.setStatus(Appointment.Status.SCHEDULE);

        return appointment;
    }

    // ---------- Manageable ----------

    @Override
    public void add(Object item) {
        if (item == null || !(item instanceof Appointment)) {
            System.out.println("Rejected: not a Appointment record.");
            return;
        }
        if (count >= appointments.length) {
            System.out.println("Rejected: Appointment store is full.");
            return;
        }
        appointments[count] = (Appointment) item;
        count = count + 1;
    }

    @Override
    public Object[] getAll() {
        Object[] result = new Object[count];
        for(int i =0; i< count; i++){
            result[i] = appointments[i];
        }
        return result;
    }

    // ---------- service-specific ----------













}
