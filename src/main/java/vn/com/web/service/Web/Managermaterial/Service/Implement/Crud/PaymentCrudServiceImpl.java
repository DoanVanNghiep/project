package vn.com.web.service.Web.Managermaterial.Service.Implement.Crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.web.service.Web.Managermaterial.Domain.PaymentMethod;
import vn.com.web.service.Web.Managermaterial.Repository.Crud.PaymentCrud;
import vn.com.web.service.Web.Managermaterial.Service.Crud.PaymentCrudService;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentCrudServiceImpl implements PaymentCrudService {
    @Autowired
    PaymentCrud paymentCrud;

    @Override
    public Optional<PaymentMethod> findById(Integer integer) {
        return paymentCrud.findById(integer);
    }

    @Override
    public PaymentMethod save(PaymentMethod entity) {
        return paymentCrud.save(entity);
    }

    @Override
    public List<PaymentMethod> saveAll(List<PaymentMethod> entities) {
        return (List<PaymentMethod>) paymentCrud.saveAll(entities);
    }


    @Override
    public boolean existsById(Integer integer) {
        return paymentCrud.existsById(integer);
    }

    @Override
    public Iterable<PaymentMethod> findAll() {
        return paymentCrud.findAll();
    }

    @Override
    public List<PaymentMethod> findAllById(List<Integer> integers) {
        return (List<PaymentMethod>) paymentCrud.findAllById(integers);
    }

    @Override
    public long count() {
        return paymentCrud.count();
    }

    @Override
    public void deleteById(Integer integer) {
        paymentCrud.deleteById(integer);
    }

    @Override
    public void delete(PaymentMethod entity) {
        paymentCrud.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        paymentCrud.deleteAllById(integers);
    }

    @Override
    public void deleteAll(List<PaymentMethod> entities) {
        paymentCrud.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        paymentCrud.deleteAll();
    }
}
