package pl.bb.produkty.pl.bb.produkty.repository;

import org.springframework.stereotype.Repository;
import pl.bb.produkty.pl.bb.produkty.modul.Product;
import pl.bb.produkty.pl.bb.produkty.modul.ProductCategory;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductListRepository {
    public List<Product> listProduct = new ArrayList<Product>();
    Product product1 = new Product("suszarka", 150, ProductCategory.ARTGOSPDOMOWEGO);
    Product product2 = new Product("woda", 2, ProductCategory.ARTSPOZYWCZE);
    Product product3 = new Product("masło", 5, ProductCategory.ARTSPOZYWCZE);
    Product product4 = new Product("patelnia", 40, ProductCategory.ARTGOSPDOMOWEGO);
    Product product5 = new Product("mleko", 4, ProductCategory.ARTSPOZYWCZE);
    Product product6 = new Product("piekarnik", 2500, ProductCategory.ARTGOSPDOMOWEGO);
    Product product7 = new Product("samochód", 5000, ProductCategory.INNE);
    Product product8 = new Product("rower", 1000, ProductCategory.INNE);

    public void addStatic() {
        listProduct.add(product1);
        listProduct.add(product2);
        listProduct.add(product3);
        listProduct.add(product4);
        listProduct.add(product5);
        listProduct.add(product6);
        listProduct.add(product7);
        listProduct.add(product8);
    }

    public List<Product> resultCategory(ProductCategory category) {
        List<Product> categoryCheck = new ArrayList<>();
        for (Product product : listProduct) {
            if (product.getCategory() == category) {
                categoryCheck.add(product);
            }
        }
        return categoryCheck;
    }

    public List<Product> getAll() {
        return listProduct;
    }

    public void addProduct(Product product) {
        listProduct.add(product);
    }
}
