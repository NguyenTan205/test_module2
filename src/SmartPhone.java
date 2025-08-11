import java.io.Serializable;

public abstract class SmartPhone implements Serializable {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String brand;

    public SmartPhone() {
    }

    public SmartPhone(int id, String name, double price, int quantity, String brand) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.setBrand(brand);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Giá bán phải là số dương!");
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public abstract String info();


    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", brand='" + brand + '\'';
    }
}
