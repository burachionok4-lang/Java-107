package DecoratorPattern;

import java.math.BigDecimal;

public class SimpleHamburger implements Hamburger {
    @Override
    public BigDecimal getCost(){
        return BigDecimal.valueOf(100.1);
    }
    @Override
    public String getDescription(){
        return "Обычный гамбургер";
    }
}
