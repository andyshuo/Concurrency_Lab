import com.sun.deploy.security.SelectableSecurityManager;

import java.util.ArrayList;

public class Terminal implements Runnable {
    private ArrayList<Seat> seats = new ArrayList<Seat>();

    public Terminal() {
        for (int i = 0; i < 5; i++) {
            seats.add(new Seat(i));
        }
    }

    public synchronized void reserve(int n) throws InterruptedException {
        seats.get(n).book();
        System.out.println("Seat "+n+" booked!!");
    }

    public synchronized void choose() throws InterruptedException {
        int[] temp = freeSeats();
        boolean seatNotFound = true;
        for (int i = 0; seatNotFound||i<5; i++) {
            if (temp[i] == 1) {
                reserve(i);
                System.out.println("Seat " + i + " chosen!!");
                return;
            }
            else
                ;
        }
    }

    public int[] freeSeats() {
        int[] freeSeats = new int[seats.size()];
        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i).getIsBooked())//Booked == true
                ;
            else
                freeSeats[i] = 1;
        }
        for (int i = 0; i < seats.size(); i++) {
            if (freeSeats[i] == 1)
                System.out.println("Seat number" + i + ": Not Booked. ");
            else
                System.out.println("Seat number " + i + " Booked. ");
        }
        System.out.println();
        return freeSeats;
    }

    @Override
    public void run() {
        try {
            choose();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
