package pl.bb.produkty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.bb.produkty.model.Product;
import pl.bb.produkty.model.ProductCategory;
import pl.bb.produkty.repository.ProductRepository;

import java.util.List;

@Controller
public class ProductListController {
    ProductRepository productRepository;

    public ProductListController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping("/lista")
    @ResponseBody
    public String list(@RequestParam(value = "kategoria", required = false) ProductCategory category) {
        String result = "";
        int sum = 0;
        List<Product> listProduct;
        if (category != null) {
            listProduct = productRepository.resultCategory(category);
        } else
            listProduct = productRepository.getAll();

        for (Product product1 : listProduct) {
            result += "Nazwa: " + product1.getName() + " cena: " + product1.getPrice() + " kategoria " + product1.getCategory() + "<br/>";
            sum += product1.getPrice();
        }

        return result + " " + "suma " + sum;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addProd(@RequestParam String nazwa, @RequestParam int cena, @RequestParam String kategoria) {

        Product product = new Product(nazwa, cena, ProductCategory.valueOf(kategoria));
        productRepository.addProduct(product);
        return "Dodano produkt: " + product.getName();
    }
}
