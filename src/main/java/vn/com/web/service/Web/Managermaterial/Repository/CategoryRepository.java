package vn.com.web.service.Web.Managermaterial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.com.web.service.Web.Managermaterial.Domain.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "select * from product where IDCATEGORY = 16",nativeQuery = true)
    List<Category> findByLapTop();

    @Query(value = "select * from product where IDCATEGORY = 17",nativeQuery = true)
    List<Category> findBySmartPhone();

    @Query(value = "select * from product where IDCATEGORY = 18",nativeQuery = true)
    List<Category> findByAccessories();

    @Query(value = "select * from product where IDCATEGORY = 19",nativeQuery = true)
    List<Category> findByCameras();

    @Query(value = "select * from product where IDCATEGORY > 19",nativeQuery = true)
    List<Category> findByRemaining();

    @Query(value = "select * from category where id <> 23",nativeQuery = true)
    List<Category> findAll();

}
