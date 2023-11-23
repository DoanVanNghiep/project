package vn.com.web.service.Web.Managermaterial.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "orders_transport", schema = "manager-material")
public class OrdersTransport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDORD")
    private Order idord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDTRANSPORT")
    private TransportMethod idtransport;

    @Column(name = "TOTAL")
    private Double total;

    @Column(name = "NOTES")
    private Integer notes;

}