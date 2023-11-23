package vn.com.web.service.Web.Managermaterial.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "transport_method", schema = "manager-material")
public class TransportMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", length = 250)
    private String name;

    @Lob
    @Column(name = "NOTES")
    private String notes;

    @Column(name = "CREATED_DATE")
    private Instant createdDate;

    @Column(name = "UPDATED_DATE")
    private Instant updatedDate;

    @Column(name = "ISACTIVE")
    private Byte isactive;

    @Column(name = "price")
    private double price;

}