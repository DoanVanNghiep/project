package vn.com.web.service.Web.Managermaterial.Service.Crud;

import vn.com.web.service.Web.Managermaterial.Domain.TransportMethod;

import java.util.List;
import java.util.Optional;

public interface TransportCrudService {
    TransportMethod save(TransportMethod entity);

    List<TransportMethod> saveAll(List<TransportMethod> entities);

    Optional<TransportMethod> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<TransportMethod> findAll();

    List<TransportMethod> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(TransportMethod entity);

    void deleteAllById(Iterable<? extends Integer> integers);

    void deleteAll(Iterable<? extends TransportMethod> entities);

    void deleteAll();
}
