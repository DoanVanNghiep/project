package vn.com.web.service.Web.Managermaterial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.web.service.Web.Managermaterial.Domain.PaymentMethod;
import vn.com.web.service.Web.Managermaterial.Domain.TransportMethod;

import java.util.List;

@Repository
public interface TransportMethodRepository extends JpaRepository<TransportMethod, Integer> {
    @Query(nativeQuery = true,value = "select * from transport_method")
    List<TransportMethod> findAll();

    @Query(nativeQuery = true,value = "select * from transport_method t  where t.id = :idTransport")
    TransportMethod findAllById(@Param("idTransport") Integer idTransport);
}
