
package th.ac.utc.product.config;

import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public NumberFormat priceFormatter() {
        return NumberFormat.getCurrencyInstance(
                new Locale("th", "TH")
        );
    }
}
