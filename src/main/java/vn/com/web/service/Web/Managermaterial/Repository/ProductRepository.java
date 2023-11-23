package vn.com.web.service.Web.Managermaterial.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import vn.com.web.service.Web.Managermaterial.Domain.Category;
import vn.com.web.service.Web.Managermaterial.Domain.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findAllById(Integer id);
    @Query(value = "select * from product where IDCATEGORY = 16",nativeQuery = true)
    List<Product> findByLapTop();

    @Query(value = "select * from product where IDCATEGORY = 17",nativeQuery = true)
    List<Product> findBySmartPhone();

    @Query(value = "select * from product where IDCATEGORY = 18",nativeQuery = true)
    List<Product> findByAccessories();

    @Query(value = "select * from product where IDCATEGORY = 19",nativeQuery = true)
    List<Product> findByCameras();

    @Query(value = "select * from product where IDCATEGORY > 19",nativeQuery = true)
    List<Product> findByRemaining();

}
