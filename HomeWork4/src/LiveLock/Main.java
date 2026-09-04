package LiveLock;

public class Main {
    public static void main(String[] args) {
        Person alice = new Person("Алиса", true);
        Person bob   = new Person("Боб", false);

        Thread t1 = new Thread(() -> alice.tryToPass(bob));
        Thread t2 = new Thread(() -> bob.tryToPass(alice));

        t1.start();
        t2.start();
    }
}
