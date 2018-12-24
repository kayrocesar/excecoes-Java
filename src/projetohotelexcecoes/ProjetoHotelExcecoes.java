package projetohotelexcecoes;

import entitties.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ProjetoHotelExcecoes {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after((checkIn))) {
            System.out.println("Error in reservation: Check-out date must be after check-in date ");
        } else {

            Reservation r = new Reservation(number, checkIn, checkOut);
            System.out.println(r);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            r.updateDates(checkIn, checkOut);
            String error = r.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("Error in reservation: " + error);
            }else{
                
                 System.out.println(r);
            }
           

        }
    }
}
