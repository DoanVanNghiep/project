package vn.com.web.service.Web.Managermaterial.Service.Implement.Crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.web.service.Web.Managermaterial.Domain.Product;
import vn.com.web.service.Web.Managermaterial.Repository.Crud.ProductCrud;
import vn.com.web.service.Web.Managermaterial.Service.Crud.ProductCrudService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCrudServiceImpl implements ProductCrudService {
    @Autowired
    ProductCrud productCrud;

    @Override
    public Product save(Product entity) {
        return productCrud.save(entity);
    }

    @Override
    public List<Product> saveAll(List<Product> entities) {
        return (List<Product>) productCrud.saveAll(entities);
    }

    @Override
    public Optional<Product> findById(Integer integer) {
        return productCrud.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return productCrud.existsById(integer);
    }

    @Override
    public Iterable<Product> findAll() {
        return productCrud.findAll();
    }

    @Override
    public List<Product> findAllById(List<Integer> integers) {
        return (List<Product>) productCrud.findAllById(integers);
    }

    @Override
    public long count() {
        return productCrud.count();
    }

    @Override
    public void deleteById(Integer integer) {
        productCrud.deleteById(integer);
    }

    @Override
    public void delete(Product entity) {
        productCrud.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        productCrud.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Product> entities) {
        productCrud.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        productCrud.deleteAll();
    }
}
