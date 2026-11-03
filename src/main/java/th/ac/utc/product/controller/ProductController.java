package th.ac.utc.product.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import th.ac.utc.product.mobel.Product;
import th.ac.utc.product.service.InMemoryProductService;
import th.ac.utc.product.service.ProductService;
@RestController
public class ProductController {
    @GetMapping("/")
    public String home(){

        return "Hello Spring Boot!";
    }
    private final ProductService productService = new InMemoryProductService();
    @GetMapping("/about")
    public String about(){

        return "This is about page";
    }
    @GetMapping("/products")
    public List<Product> list() {

        return productService.findAll();
    }
    @GetMapping("/product")
    public Product one(@RequestParam Long id) {
        return productService.findById(id).orElse(null);
    }
    @GetMapping("products/search")
    public List<Product> search(@RequestParam String keyword){
        return productService.findByName(keyword);
    }
}
