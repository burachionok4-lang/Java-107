package DecoratorPattern;

import java.math.BigDecimal;

public class SalatDecorator extends HamburgerDecorator{
    SalatDecorator(Hamburger hamburger){
        super(hamburger);
    }
    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(5.7));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", с салатом";
    }
}
