package LiveLock;

class Person {
    private final String name;
    private boolean movingRight;

    public Person(String name, boolean movingRight) {
        this.name = name;
        this.movingRight = movingRight;
    }

    public void tryToPass(Person other) {
        while (true) {
            if (this.movingRight != other.movingRight) {
                System.out.println(name + " видит " + other.name + " и уступает...");

                this.movingRight = true;
                other.movingRight = false;

                try { Thread.sleep(100); } catch (InterruptedException e) {}
            } else {
                System.out.println(name + " успешно прошёл!");
                break;
            }
        }
    }
}