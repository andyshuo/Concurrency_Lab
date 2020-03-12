public class Concert
{
    public static void main(String[] args) throws InterruptedException {
        Terminal terminal = new Terminal();

        Thread a = new Thread(terminal);
        Thread b = new Thread(terminal);
        Thread c = new Thread(terminal);

        a.start();
        b.start();
        c.start();
        a.join();
        b.join();
        c.join();
    }
}
