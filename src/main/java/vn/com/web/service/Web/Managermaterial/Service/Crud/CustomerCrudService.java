package vn.com.web.service.Web.Managermaterial.Service.Crud;

import vn.com.web.service.Web.Managermaterial.Domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerCrudService {
    Customer save(Customer entity);

    List<Customer> saveAll(List<Customer> entities);

    Optional<Customer> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Customer> findAll();

    List<Customer> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(Customer entity);

    void deleteAllById(Iterable<? extends Integer> integers);

    void deleteAll(Iterable<? extends Customer> entities);

    void deleteAll();
}
