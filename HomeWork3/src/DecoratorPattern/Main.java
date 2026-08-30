package DecoratorPattern;

public class Main {
        public static void main(String[] args) {
            Hamburger hamburger = new SimpleHamburger();
            System.out.println(hamburger.getDescription() +" "+ hamburger.getCost()+"Руб");

            Hamburger cheeseBurger = new CheeseDecorator(new SimpleHamburger());
            System.out.println(cheeseBurger.getDescription() +" "+ cheeseBurger.getCost()+"Руб");

            Hamburger baconHamburger = new BaconDecorator(new OnionDecorator(new SalatDecorator(new BaconDecorator(new SimpleHamburger()))));
            System.out.println(baconHamburger.getDescription() +" "+ baconHamburger.getCost()+"Руб");
        }
}
