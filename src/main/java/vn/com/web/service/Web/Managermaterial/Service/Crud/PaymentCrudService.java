package vn.com.web.service.Web.Managermaterial.Service.Crud;

import vn.com.web.service.Web.Managermaterial.Domain.PaymentMethod;

import java.util.List;
import java.util.Optional;

public interface PaymentCrudService {
    Optional<PaymentMethod> findById(Integer integer);

    PaymentMethod save(PaymentMethod entity);

    List<PaymentMethod> saveAll(List<PaymentMethod> entities);

    boolean existsById(Integer integer);

    Iterable<PaymentMethod> findAll();

    List<PaymentMethod> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(PaymentMethod entity);

    void deleteAllById(Iterable<? extends Integer> integers);

    void deleteAll(List<PaymentMethod> entities);

    void deleteAll();
}
