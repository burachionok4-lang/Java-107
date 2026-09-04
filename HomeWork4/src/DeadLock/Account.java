package DeadLock;

class Account {
    private int balance;
    private final String name;

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void transfer(Account to, int amount) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() +
                    " захватил счёт " + this.name);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }

            System.out.println(Thread.currentThread().getName() +
                    " пытается захватить счёт " + to.name);
            synchronized (to) {
                this.balance -= amount;
                to.balance += amount;
                System.out.println(Thread.currentThread().getName() +
                        " перевёл " + amount + " с " + this.name + " на " + to.name);
            }
        }
    }
}