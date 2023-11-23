package vn.com.web.service.Web.Managermaterial.Service.Crud;

import vn.com.web.service.Web.Managermaterial.Domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryCrudService {
    Category save(Category entity);

    List<Category> saveAll(List<Category> entities);

    Optional<Category> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Category> findAll();

    List<Category> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(Category entity);

    void deleteAllById(Iterable<? extends Integer> integers);

    void deleteAll(Iterable<? extends Category> entities);

    void deleteAll();
}
