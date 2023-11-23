package vn.com.web.service.Web.Managermaterial.Mapper;

import vn.com.web.service.Web.Managermaterial.Domain.Product;
import vn.com.web.service.Web.Managermaterial.Dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper implements EntityMapper<Product, ProductDto>{
    @Override
    public Product toEntity(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .build();
    }

    @Override
    public List<Product> toEntity(List<ProductDto> d) {
        List<Product> products = new ArrayList<>();
        d.forEach(productDto -> {
            products.add(toEntity(productDto));
        });
        return products;
    }

    @Override
    public ProductDto toDTO(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .image(product.getImage())
                .notes(product.getNotes())
                .price(product.getPrice())
                .createdBy(product.getCreatedBy())
                .createdDate(product.getCreatedDate())
                .description(product.getDescription())
                .idcategory(product.getIdcategory())
                .isactive(product.getIsactive())
                .quatity(product.getQuatity())
                .updatedDate(product.getUpdatedDate())
                .updatedBy(product.getUpdatedBy())
                .build();
    }

    @Override
    public List<ProductDto> toDTO(List<Product> e) {
        List<ProductDto> productDtoList = new ArrayList<>();
        e.forEach(product -> {
            productDtoList.add(toDTO(product));
        });
        return productDtoList;
    }
}
