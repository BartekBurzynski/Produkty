package pl.bb.produkty.pl.bb.produkty.service;

import pl.bb.produkty.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListService {
    public List<Product> listProduct = new ArrayList<Product>();
    Product product1 = new Product("suszarka", 150, "Art. gosp. domowego");
    Product product2 = new Product("woda", 2, "Art. spożywcze");
    Product product3 = new Product("masło", 5, "Art. spożywcze");
    Product product4 = new Product("patelnia", 40, "Art. gosp. domowego");
    Product product5 = new Product("mleko", 4, "Art. spożywcze");
    Product product6 = new Product("piekarnik", 2500, "Art. gosp. domowego");
    Product product7 = new Product("samochód", 5000, "Inne");
    Product product8 = new Product("rower", 1000, "Inne");

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

    public List<Product> getAll() {
        return listProduct;
    }

    public void addProduct(Product product) {
        listProduct.add(product);
    }
}
