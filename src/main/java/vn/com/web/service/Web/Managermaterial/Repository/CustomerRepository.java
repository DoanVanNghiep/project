package vn.com.web.service.Web.Managermaterial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.com.web.service.Web.Managermaterial.Domain.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from Customer c where USERNAME = ?",nativeQuery = true)
    Customer findByUsername(String username);
    @Query(value = "select * from Customer c where c.isactive < 2",nativeQuery = true )
    List<Customer> findAll();
}
