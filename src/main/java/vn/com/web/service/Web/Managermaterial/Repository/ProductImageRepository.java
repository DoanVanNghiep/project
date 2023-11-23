package vn.com.web.service.Web.Managermaterial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.web.service.Web.Managermaterial.Domain.ProductImage;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
    @Query(value = "select * from product_images where product_images.ID_PRODUCT = :id",nativeQuery = true)
    List<ProductImage> getProductImage(@Param("id") Integer id);
}
