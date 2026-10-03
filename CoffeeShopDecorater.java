interface Coffee {
    String getDescription();
    double getCost();
}

class Espresso implements Coffee {
    @Override
    public String getDescription() {
        return "Espresso";
    }
    @Override
    public double getCost() {
        return 2.00;
    }
}

class Cappuccino implements Coffee {
    @Override
    public String getDescription() {
        return "Cappuccino";
    }

    @Override
    public double getCost() {
        return 3.00;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.50;
    }
}

public class CoffeeShopDecorater {
    public static void main(String[] args) {
        // Dynamic wrapping: Espresso + Milk
        Coffee coffee = new Espresso();
        coffee = new MilkDecorator(coffee);

        System.out.println("Order: " + coffee.getDescription());
        System.out.println("Total Cost: $" + coffee.getCost());
    }
}