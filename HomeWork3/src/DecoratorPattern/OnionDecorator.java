package DecoratorPattern;

import java.math.BigDecimal;

public class OnionDecorator extends HamburgerDecorator{
    OnionDecorator(Hamburger hamburger){
        super(hamburger);
    }
    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(15.2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", с луком";
    }
}
