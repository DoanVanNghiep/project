package vn.com.web.service.Web.Managermaterial.Service.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import vn.com.web.service.Web.Managermaterial.Domain.Product;
import vn.com.web.service.Web.Managermaterial.Repository.ProductRepository;
import vn.com.web.service.Web.Managermaterial.Service.ProductService;

import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    public <S extends Product> Iterable<S> saveAll(Iterable<S> entities) {
        return productRepository.saveAll(entities);
    }

    public Optional<Product> findById(Integer integer) {
        return productRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return productRepository.existsById(integer);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Iterable<Product> findAllById(Iterable<Integer> integers) {
        return productRepository.findAllById(integers);
    }

    public long count() {
        return productRepository.count();
    }

    public void deleteById(Integer integer) {
        productRepository.deleteById(integer);
    }

    public void delete(Product entity) {
        productRepository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> integers) {
        productRepository.deleteAllById(integers);
    }

    public void deleteAll(Iterable<? extends Product> entities) {
        productRepository.deleteAll(entities);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }
}
