package pl.bb.produkty.pl.bb.produkty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.bb.produkty.pl.bb.produkty.Product;
import pl.bb.produkty.pl.bb.produkty.service.ProductListService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductListController {
    ProductListService productList = new ProductListService();

    @GetMapping("/addStatic")
    public String staticAdd() {
        productList.addStatic();
        return "redirect:/";
    }


    @GetMapping("/lista")
    @ResponseBody
    public String list(@RequestParam(value = "kategoria") String category) {
        String result = "";
        int sum = 0;
        List<Product> listProduct = productList.getAll();
        List<Product> newProductList = new ArrayList<>();

        for (Product product : listProduct) {
            switch (category) {
                case "spozywcze":
                    if (product.getCategory().equals("Art. spożywcze"))
                        newProductList.add(product);

                    break;
                case "gospodarstwa":
                    if (product.getCategory().equals("Art. gosp. domowego"))
                        newProductList.add(product);
                    break;
                case "inne":
                    if (product.getCategory().equals("Inne"))
                        newProductList.add(product);
                    break;
                case "wszystkie":
                    newProductList.add(product);
            }
        }
        for (Product product1 : newProductList) {
            result += "Nazwa: " + product1.getName() + " cena: " + product1.getPrice() + " kategoria " + product1.getCategory() + "<br/>";
            sum += product1.getPrice();
        }


        return result + " " + "suma " + sum;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addProd(@RequestParam String nazwa, @RequestParam int cena, @RequestParam String kategoria) {

        Product product = new Product(nazwa, cena, kategoria);
        productList.addProduct(product);
        return "Dodano produkt: " + product.getName();
    }
}
