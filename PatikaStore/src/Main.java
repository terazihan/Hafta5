import java.util.*;

class Brand {
    private int id;
    private String name;

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

abstract class Product {
    private static int count = 0;
    private int id;
    private double price;
    private double discount;
    private int stock;
    private String name;
    private Brand brand;

    public Product(double price, double discount, int stock, String name, Brand brand) {
        this.id = ++count;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.name = name;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return String.format("| %-3d | %-30s | %-10.2f | %-10s |", id, name, price, brand.getName());
    }
}

class MobilePhone extends Product {
    private String storage;
    private double screenSize;
    private int batteryPower;
    private int ram;
    private String color;

    public MobilePhone(double price, double discount, int stock, String name, Brand brand, String storage, double screenSize, int batteryPower, int ram, String color) {
        super(price, discount, stock, name, brand);
        this.storage = storage;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | %-8s | %-5.1f | %-10d | %-4d | %-6s |", storage, screenSize, batteryPower, ram, color);
    }
}

class Notebook extends Product {
    private int ram;
    private int storage;
    private double screenSize;

    public Notebook(double price, double discount, int stock, String name, Brand brand, int ram, int storage, double screenSize) {
        super(price, discount, stock, name, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | %-3d GB SSD | %-4.1f inç | %-3d GB |", ram, screenSize, storage);
    }
}

class Store {
    private List<Brand> brands;
    private List<Product> products;

    public Store() {
        brands = new ArrayList<>();
        products = new ArrayList<>();

        // Markaları ekleyelim
        addBrand(new Brand(1, "Samsung"));
        addBrand(new Brand(2, "Lenovo"));
        addBrand(new Brand(3, "Apple"));
        addBrand(new Brand(4, "Huawei"));
        addBrand(new Brand(5, "Casper"));
        addBrand(new Brand(6, "Asus"));
        addBrand(new Brand(7, "HP"));
        addBrand(new Brand(8, "Xiaomi"));
        addBrand(new Brand(9, "Monster"));
    }

    public void addBrand(Brand brand) {
        brands.add(brand);
        Collections.sort(brands, Comparator.comparing(Brand::getName));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getProductsByBrand(int brandId) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            if (product.getBrand().getId() == brandId) {
                productList.add(product);
            }
        }
        return productList;
    }

    public void removeProduct(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                products.remove(product);
                break;
            }
        }
    }

    public void listProducts(List<Product> productList) {
        if (productList.isEmpty()) {
            System.out.println("Listelenecek ürün bulunamadı.");
            return;
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | RAM         |");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Product product : productList) {
            System.out.println(product);
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nPatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Tercihiniz : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nNotebook Listesi\n");
                    store.listProducts(store.getProductsByBrand(2)); // Notebook marka id'si 2
                    break;
                case 2:
                    System.out.println("\nCep Telefonu Listesi\n");
                    store.listProducts(store.getProductsByBrand(1)); // Cep telefonu marka id'si 1
                    break;
                case 3:
                    System.out.println("\nMarkalarımız");
                    System.out.println("--------------");
                    for (Brand brand : store.getBrands()) {
                        System.out.println("- " + brand);
                    }
                    break;
                case 0:
                    System.out.println("\nProgramdan çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçenek, lütfen tekrar deneyin.");
            }
        } while (choice != 0);
        scanner.close();
    }
}
