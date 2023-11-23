package vn.com.web.service.Web.Managermaterial.Service.Crud;

import vn.com.web.service.Web.Managermaterial.Domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductCrudService {
    Product save(Product entity);

    List<Product> saveAll(List<Product> entities);

    Optional<Product> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Product> findAll();

    List<Product> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(Product entity);

    void deleteAllById(Iterable<? extends Integer> integers);

    void deleteAll(Iterable<? extends Product> entities);

    void deleteAll();
}
