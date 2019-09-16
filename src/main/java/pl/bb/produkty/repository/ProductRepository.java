package pl.bb.produkty.repository;

import org.springframework.stereotype.Repository;
import pl.bb.produkty.model.Product;
import pl.bb.produkty.model.ProductCategory;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    public List<Product> listProduct;

    public ProductRepository() {
        listProduct = new ArrayList<Product>();
        listProduct.add(new Product("suszarka", 150, ProductCategory.ARTGOSPDOMOWEGO));
        listProduct.add(new Product("woda", 2, ProductCategory.ARTSPOZYWCZE));
        listProduct.add(new Product("masło", 5, ProductCategory.ARTSPOZYWCZE));
        listProduct.add(new Product("patelnia", 40, ProductCategory.ARTGOSPDOMOWEGO));
        listProduct.add(new Product("mleko", 4, ProductCategory.ARTSPOZYWCZE));
        listProduct.add(new Product("piekarnik", 2500, ProductCategory.ARTGOSPDOMOWEGO));
        listProduct.add(new Product("samochód", 5000, ProductCategory.INNE));
        listProduct.add(new Product("rower", 1000, ProductCategory.INNE));
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
