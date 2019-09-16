package pl.bb.produkty.pl.bb.produkty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.bb.produkty.pl.bb.produkty.modul.Product;
import pl.bb.produkty.pl.bb.produkty.modul.ProductCategory;
import pl.bb.produkty.pl.bb.produkty.repository.ProductListRepository;

import java.util.List;

@Controller
public class ProductListController {
    ProductListRepository productList = new ProductListRepository();

    public ProductListController(ProductListRepository productList) {
        this.productList = productList;
    }

    @GetMapping("/addStatic")
    public String staticAdd() {
        productList.addStatic();
        return "redirect:/";
    }


    @GetMapping("/lista")
    @ResponseBody
    public String list(@RequestParam(value = "kategoria") ProductCategory category) {
        String result = "";
        int sum = 0;
        List<Product> listProduct = productList.resultCategory(category);
        //  List<Product> newProductList = new ArrayList<>();

        //  for (Product product : listProduct) {


        //     switch (category) {
        //         case "spozywcze":
        //             if (product.getCategory().equals("Art. spożywcze"))
        //                 newProductList.add(product);

        //             break;
        //         case "gospodarstwa":
        //             if (product.getCategory().equals("Art. gosp. domowego"))
        //                 newProductList.add(product);
        //             break;
        //         case "inne":
        //             if (product.getCategory().equals("Inne"))
        //                 newProductList.add(product);
        //             break;
        //         case "wszystkie":
        //             newProductList.add(product);
        //     }
        //   }
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
        productList.addProduct(product);
        return "Dodano produkt: " + product.getName();
    }
}
