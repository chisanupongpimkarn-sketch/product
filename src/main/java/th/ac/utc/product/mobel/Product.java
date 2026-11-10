package th.ac.utc.product.mobel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import th.ac.utc.product.controller.ReportController;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    private Long id;
    private String name;
    private double price;
    private int stock;
    public double getTotalValue() { return price * stock; }
}

