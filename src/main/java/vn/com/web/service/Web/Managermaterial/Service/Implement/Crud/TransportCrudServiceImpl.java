package vn.com.web.service.Web.Managermaterial.Service.Implement.Crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.web.service.Web.Managermaterial.Domain.TransportMethod;
import vn.com.web.service.Web.Managermaterial.Repository.Crud.TransportCrud;
import vn.com.web.service.Web.Managermaterial.Service.Crud.TransportCrudService;

import java.util.List;
import java.util.Optional;

@Service
public class TransportCrudServiceImpl implements TransportCrudService {
    @Autowired
    TransportCrud transportCrud;

    @Override
    public TransportMethod save(TransportMethod entity) {
        return transportCrud.save(entity);
    }

    @Override
    public List<TransportMethod> saveAll(List<TransportMethod> entities) {
        return(List<TransportMethod>) transportCrud.saveAll(entities);
    }

    @Override
    public Optional<TransportMethod> findById(Integer integer) {
        return transportCrud.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return transportCrud.existsById(integer);
    }

    @Override
    public Iterable<TransportMethod> findAll() {
        return transportCrud.findAll();
    }

    @Override
    public List<TransportMethod> findAllById(List<Integer> integers) {
        return (List<TransportMethod>) transportCrud.findAllById(integers);
    }

    @Override
    public long count() {
        return transportCrud.count();
    }

    @Override
    public void deleteById(Integer integer) {
        transportCrud.deleteById(integer);
    }

    @Override
    public void delete(TransportMethod entity) {
        transportCrud.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        transportCrud.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends TransportMethod> entities) {
        transportCrud.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        transportCrud.deleteAll();
    }
}
