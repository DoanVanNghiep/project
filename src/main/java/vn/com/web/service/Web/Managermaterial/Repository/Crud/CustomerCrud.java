package vn.com.web.service.Web.Managermaterial.Repository.Crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.web.service.Web.Managermaterial.Domain.Customer;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface CustomerCrud extends CrudRepository<Customer,Integer> {
}
