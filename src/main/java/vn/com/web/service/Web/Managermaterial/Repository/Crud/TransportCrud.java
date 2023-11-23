package vn.com.web.service.Web.Managermaterial.Repository.Crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.web.service.Web.Managermaterial.Domain.TransportMethod;

@Repository
public interface TransportCrud extends CrudRepository<TransportMethod, Integer> {
}
