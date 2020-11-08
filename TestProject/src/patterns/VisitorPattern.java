package patterns;

import java.util.ArrayList;
import java.util.List;

public class VisitorPattern {
    public static void main(String[] args) {
        ShopStation cashier = new Cashier();
        ShopStation weighStation = new WeightStation();
        ShopStation cart = new ShoppingCart();
        
        List<ShoppingItem> items = List.of(new Beer(), new Beer(), new Milk());
        items.forEach((item)->weighStation.visit(item));
        items.forEach((item)->cart.visit(item));

        System.out.println(weighStation.getTotal());
        System.out.println(cart.getTotal());

        cashier.visit((ShoppingItem)cart);
        System.out.println(cashier.getTotal());
    }
}

interface ShoppingItem{
    void accept(ShopStation c);
    double getCost();
    double getWeight();
}

class Beer implements ShoppingItem{
    public void accept(ShopStation c) {
        c.visit(this);
    }
    public double getCost() {
        return 1.99;
    }
    public double getWeight() {
        return 0.5;
    }
    @Override
    public String toString() {
        return String.format("Beer: %.2f €", getCost());
    }
}

class Milk implements ShoppingItem{
    public void accept(ShopStation c) {
        c.visit(this);
    }
    public double getCost() {
        return 1.2;
    }
    public double getWeight() {
        return 1.0;
    }
    @Override
    public String toString() {
        return String.format("Milk: %.2f €", getCost());
    }
}

interface ShopStation{
    void visit(ShoppingItem item);
    String getTotal();
}

class Cashier implements ShopStation{
    double total = 0;
    public void visit(ShoppingItem item){
        total += item.getCost();
    }
    public String getTotal() {
        return String.format("%.2f €", total);
    }
}

class WeightStation implements ShopStation{
    double total = 0;
    public void visit(ShoppingItem item){
        total += item.getWeight();
    }
    public String getTotal() {
        return String.format("%.2f KG", total);
    }
}

class ShoppingCart implements ShopStation, ShoppingItem{
    ArrayList<ShoppingItem> items = new ArrayList<>();
    public void visit(ShoppingItem item) {
        items.add(item);
    }
    public String getTotal() {
        return items.stream().map((item)->item.toString()).reduce((a,b)->a+"\n"+b).get();
    }

    @Override
    public void accept(ShopStation c) {
        c.visit(this);
    }

    @Override
    public double getCost() { 
        double total = items.stream().map((item)->item.getCost()).reduce((a,b)->a+b).get();
        return total;
    }

    @Override
    public double getWeight() {
        double total = items.stream().map((item)->item.getWeight()).reduce((a,b)->a+b).get();
        return total;
    }
}