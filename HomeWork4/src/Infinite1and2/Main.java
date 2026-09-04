package Infinite1and2;

public class Main {
    private static final Object lock = new Object();
    private static boolean isFirstTurn = true;

    public static void main(String[] args) {
            Thread thread1 = new Thread(() -> {
                while (true) {
                    synchronized (lock) {
                        while (!isFirstTurn) { // если не его очередь, ждём
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(1);
                        isFirstTurn = false;   // передаём очередь второму
                        lock.notify();         // пробуждаем второй поток
                    }
                }
            });

            Thread thread2 = new Thread(() -> {
                while (true) {
                    synchronized (lock) {
                        while (isFirstTurn) { // если очередь первого, ждём
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(2);
                        isFirstTurn = true;    // передаём очередь первому
                        lock.notify();
                    }
                }
            });
            thread1.start();
            thread2.start();
        }
    }