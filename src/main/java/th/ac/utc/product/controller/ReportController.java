
package th.ac.utc.product.controller;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import th.ac.utc.product.mobel.Product;
import th.ac.utc.product.service.ProductService;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ProductService productService;

    private final NumberFormat priceFormatter =
            NumberFormat.getNumberInstance(Locale.US);

    @GetMapping("/report")
    public Map<String, Object> report() {

        List<Product> all = productService.findAll();

        double total = all.stream()
                .mapToDouble(Product::getTotalValue)
                .sum();

        return Map.of(
                "count", all.size(),
                "totalValue", priceFormatter.format(total));
    }
}
