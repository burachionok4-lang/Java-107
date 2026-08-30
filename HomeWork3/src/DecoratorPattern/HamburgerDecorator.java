package DecoratorPattern;

import java.math.BigDecimal;

public abstract class HamburgerDecorator implements Hamburger{
protected Hamburger decoratedHamburger;
public HamburgerDecorator(Hamburger hamburger){
    this.decoratedHamburger = hamburger;
}
    @Override
    public BigDecimal getCost() {
        return decoratedHamburger.getCost();
    }

    @Override
    public String getDescription() {
        return decoratedHamburger.getDescription();
    }
}
