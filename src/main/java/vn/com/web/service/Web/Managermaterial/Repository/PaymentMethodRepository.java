package vn.com.web.service.Web.Managermaterial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.web.service.Web.Managermaterial.Domain.PaymentMethod;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {
    @Query(value = "select p from PaymentMethod p where p.id = :idPayment")
    PaymentMethod findAllById(@Param("idPayment") Integer idPayment);
}
