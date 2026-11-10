package th.ac.utc.product.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    private final String shopName;
    private final double vatRate;
    private final Environment env;
    private final String developer;
    public InfoController(@Value("${shop.name}") String shopName,
                          @Value("${shop.vat-rate}") double vatRate,
                          @Value("${shop.developer}") String developer,

                          Environment env) {

        this.shopName = shopName;
        this.vatRate = vatRate;
        this.env = env;
        this.developer = developer;
    }
    @GetMapping("/info")
    public Map<String, Object> info() {
        return Map.of("shopName", shopName,
                "vatRate", vatRate,
                "developer",developer,
                "profiles", env.getActiveProfiles());

    }
}
