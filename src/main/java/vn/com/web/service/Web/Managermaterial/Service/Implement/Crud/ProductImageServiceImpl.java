package vn.com.web.service.Web.Managermaterial.Service.Implement.Crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.web.service.Web.Managermaterial.Domain.ProductImage;
import vn.com.web.service.Web.Managermaterial.Repository.Crud.ProductImageCrud;
import vn.com.web.service.Web.Managermaterial.Service.Crud.ProductImageCrudService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImageServiceImpl implements ProductImageCrudService {
    @Autowired
    ProductImageCrud productImageCrud;

    @Override
    public ProductImage save(ProductImage entity) {
        return productImageCrud.save(entity);
    }

    @Override
    public List<ProductImage> saveAll(List<ProductImage> entities) {
        return (List<ProductImage>) productImageCrud.saveAll(entities);
    }

    @Override
    public Optional<ProductImage> findById(Integer integer) {
        return productImageCrud.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return productImageCrud.existsById(integer);
    }

    @Override
    public Iterable<ProductImage> findAll() {
        return productImageCrud.findAll();
    }

    @Override
    public List<ProductImage> findAllById(List<Integer> integers) {
        return (List<ProductImage>) productImageCrud.findAllById(integers);
    }

    @Override
    public long count() {
        return productImageCrud.count();
    }

    @Override
    public void deleteById(Integer integer) {
        productImageCrud.deleteById(integer);
    }

    @Override
    public void delete(ProductImage entity) {
        productImageCrud.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        productImageCrud.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends ProductImage> entities) {
        productImageCrud.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        productImageCrud.deleteAll();
    }
}
