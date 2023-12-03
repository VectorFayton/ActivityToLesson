class Product {
    float price;
    String name;
    String category;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Product(float price, String name, String category) {
        this.price = price;
        this.name = name;
        this.category = category;
    }
}

interface PricingStrategy {
    void setPrice(Product product);
}

interface DiscountStrategy {
    void applyDiscount(Product product);
}

interface ShippingStrategy {
    void applyShipping(Product product);
}

class ElectronicPricingStrategy implements PricingStrategy {
    @Override
    public void setPrice(Product product) {
        product.setPrice(product.getPrice() + 40);
    }
}

class ClothingDiscountStrategy implements DiscountStrategy {
    @Override
    public void applyDiscount(Product product) {
        product.setPrice(product.getPrice() - (product.getPrice() * 20 / 100));
    }
}

class BooksShippingStrategy implements ShippingStrategy {
    @Override
    public void applyShipping(Product product) {
        // Implement shipping strategy for books
    }
}

public class Main {
    public static void main(String[] args) {
        Product cloth = new Product(300, "T-shirt", "Clothes");

        // Apply pricing strategy
        PricingStrategy pricingStrategy = new ElectronicPricingStrategy();
        pricingStrategy.setPrice(cloth);

        // Apply discount strategy
        DiscountStrategy discountStrategy = new ClothingDiscountStrategy();
        discountStrategy.applyDiscount(cloth);

        // Apply shipping strategy (just an example, you need to implement it)
        ShippingStrategy shippingStrategy = new BooksShippingStrategy();
        shippingStrategy.applyShipping(cloth);

        // Output the final price
        System.out.println("Final Price: " + cloth.getPrice());
    }
}
