package DeadLock;

public class Main {
    public static void main(String[] args) {
        Account accountA = new Account("A", 1000);
        Account accountB = new Account("B", 1000);

        Thread t1 = new Thread(() -> {
            accountA.transfer(accountB, 100);
        }, "Поток-1");

        Thread t2 = new Thread(() -> {
            accountB.transfer(accountA, 100);
        }, "Поток-2");

        t1.start();
        t2.start();
    }
}
