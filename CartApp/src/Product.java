public class Product {
    private int key;
    private String name;
    private int price;

    Product (int key, String name, int price) {
        this.key = key;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object object) {
        Product anotherObject = (Product) object;
        return (this.name.equals(anotherObject.name));
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
