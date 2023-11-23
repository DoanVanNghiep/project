package vn.com.web.service.Web.Managermaterial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.web.service.Web.Managermaterial.Domain.OrdersPayment;

@Repository
public interface OrderPaymentRepository extends JpaRepository<OrdersPayment, Integer> {
}
