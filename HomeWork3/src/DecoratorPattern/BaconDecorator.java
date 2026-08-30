package DecoratorPattern;

import java.math.BigDecimal;

public class BaconDecorator extends HamburgerDecorator{
    BaconDecorator(Hamburger hamburger){
        super(hamburger);
    }
    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(30.9));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", с беконом";
    }
}
