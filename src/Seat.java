public class Seat {
    public int seatNum;
    public boolean isBooked;

    public Seat(int seatNum)
    {
        this.seatNum = seatNum;
        this.isBooked=false;
    }

    public boolean getIsBooked(){
        return isBooked;
    }

    public void book()
    {
        this.isBooked=true;
    }

}
