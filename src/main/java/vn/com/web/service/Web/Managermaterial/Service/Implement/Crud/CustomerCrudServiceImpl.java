package vn.com.web.service.Web.Managermaterial.Service.Implement.Crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.web.service.Web.Managermaterial.Domain.Customer;
import vn.com.web.service.Web.Managermaterial.Repository.Crud.CustomerCrud;
import vn.com.web.service.Web.Managermaterial.Service.Crud.CustomerCrudService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerCrudServiceImpl implements CustomerCrudService {
    @Autowired
    CustomerCrud customerCrud;

    @Override
    public Customer save(Customer entity) {
        return customerCrud.save(entity);
    }

    @Override
    public List<Customer> saveAll(List<Customer> entities) {
        return (List<Customer>)customerCrud.saveAll(entities);
    }

    @Override
    public Optional<Customer> findById(Integer integer) {
        return customerCrud.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return customerCrud.existsById(integer);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerCrud.findAll();
    }

    @Override
    public List<Customer> findAllById(List<Integer> integers) {
        return (List<Customer>) customerCrud.findAllById(integers);
    }

    @Override
    public long count() {
        return customerCrud.count();
    }

    @Override
    public void deleteById(Integer integer) {
        customerCrud.deleteById(integer);
    }

    @Override
    public void delete(Customer entity) {
        customerCrud.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        customerCrud.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Customer> entities) {
        customerCrud.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        customerCrud.deleteAll();
    }
}
