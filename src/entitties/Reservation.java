package entitties;

import exceptions.DomainException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer rooNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation()  {
        if (!checkOut.after((checkIn))) {
            throw new DomainException("Check-out date must be after check-in date ");
        }
    }

    public Reservation(Integer rooNumber, Date checkIn, Date checkOut)  {
        if (!checkOut.after((checkIn))) {
            throw new DomainException("Check-out date must be after check-in date ");
        }
        this.rooNumber = rooNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRooNumber() {
        return rooNumber;
    }

    public void setRooNumber(Integer rooNumber) {
        this.rooNumber = rooNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration() {
        long diffMilisegundos = checkOut.getTime() - checkIn.getTime();

        return TimeUnit.DAYS.convert(diffMilisegundos, TimeUnit.MILLISECONDS);

    }

    public void updateDates(Date checkIn, Date checkout)  {

        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {

            throw new DomainException(" Reservation dates for update must be future dates");
        }
        if (!checkOut.after((checkIn))) {
            throw new DomainException("Check-out date must be after check-in date ");
        }
        this.checkIn = checkIn;
        this.checkOut = checkout;

    }

    @Override
    public String toString() {
        return "Room "
                + rooNumber
                + ", check-in:  "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + " , "
                + duration()
                + " nights ";

    }

}
