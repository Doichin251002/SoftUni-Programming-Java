package softuni.shop.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CategorySummaryInfoModel {
    private String category;
    private Long productCount;
    private Double averagePrice;
    private BigDecimal totalRevenue;

    public CategorySummaryInfoModel(String category, Long productCount, Double averagePrice, BigDecimal totalRevenue) {
        this.category = category;
        this.productCount = productCount;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }
}
