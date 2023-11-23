package vn.com.web.service.Web.Managermaterial.Repository.Crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.web.service.Web.Managermaterial.Domain.PaymentMethod;

import java.util.List;

@Repository
public interface PaymentCrud extends CrudRepository<PaymentMethod, Integer> {
}
