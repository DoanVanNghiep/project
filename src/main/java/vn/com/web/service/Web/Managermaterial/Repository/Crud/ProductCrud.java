package vn.com.web.service.Web.Managermaterial.Repository.Crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.web.service.Web.Managermaterial.Domain.Product;

@Repository
public interface ProductCrud extends CrudRepository<Product, Integer> {
}
