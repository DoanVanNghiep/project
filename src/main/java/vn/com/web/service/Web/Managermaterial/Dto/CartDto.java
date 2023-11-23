package vn.com.web.service.Web.Managermaterial.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.web.service.Web.Managermaterial.Domain.Product;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private double totalPrice = 0;
    private int qty = 1;
    private Product product ;
}