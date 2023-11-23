package vn.com.web.service.Web.Managermaterial.Service.Crud;

import vn.com.web.service.Web.Managermaterial.Domain.ProductImage;

import java.util.List;
import java.util.Optional;

public interface ProductImageCrudService {
    ProductImage save(ProductImage entity);

    List<ProductImage> saveAll(List<ProductImage> entities);

    Optional<ProductImage> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<ProductImage> findAll();

    List<ProductImage> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(ProductImage entity);

    void deleteAllById(Iterable<? extends Integer> integers);

    void deleteAll(Iterable<? extends ProductImage> entities);

    void deleteAll();
}
