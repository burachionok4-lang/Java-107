package DecoratorPattern;

import java.math.BigDecimal;

public class CheeseDecorator extends HamburgerDecorator{
    CheeseDecorator(Hamburger hamburger){
        super(hamburger);
    }
    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(27.5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", теперь чизбургер";
    }
}
