package vn.com.web.service.Web.Managermaterial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.web.service.Web.Managermaterial.Domain.OrdersDetail;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrdersDetail, Integer> {
}
