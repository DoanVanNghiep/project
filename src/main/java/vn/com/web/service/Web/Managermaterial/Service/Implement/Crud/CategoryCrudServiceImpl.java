package vn.com.web.service.Web.Managermaterial.Service.Implement.Crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.web.service.Web.Managermaterial.Domain.Category;
import vn.com.web.service.Web.Managermaterial.Repository.Crud.CategoryCrud;
import vn.com.web.service.Web.Managermaterial.Service.Crud.CategoryCrudService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryCrudServiceImpl implements CategoryCrudService {

    @Autowired
    CategoryCrud categoryCrud;

    @Override
    public Category save(Category entity) {
        return categoryCrud.save(entity);
    }

    @Override
    public List<Category> saveAll(List<Category> entities) {
        return (List<Category> ) categoryCrud.saveAll(entities);
    }

    @Override
    public Optional<Category> findById(Integer integer) {
        return categoryCrud.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return categoryCrud.existsById(integer);
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryCrud.findAll();
    }

    @Override
    public List<Category> findAllById(List<Integer> integers) {
        return (List<Category>) categoryCrud.findAllById(integers);
    }

    @Override
    public long count() {
        return categoryCrud.count();
    }

    @Override
    public void deleteById(Integer integer) {
        categoryCrud.deleteById(integer);
    }

    @Override
    public void delete(Category entity) {
        categoryCrud.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        categoryCrud.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Category> entities) {
        categoryCrud.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        categoryCrud.deleteAll();
    }
}
