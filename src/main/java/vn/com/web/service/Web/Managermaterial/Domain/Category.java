package vn.com.web.service.Web.Managermaterial.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "category", schema = "manager-material")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPARENT")
    private Integer idparent;

    @Column(name = "NAME", length = 500)
    private String name;

    @Lob
    @Column(name = "NOTES")
    private String notes;

    @Column(name = "ICON", length = 250)
    private String icon;

    @Column(name = "CREATED_DATE")
    private Instant createdDate;

    @Column(name = "UPDATED_DATE")
    private Instant updatedDate;

    @Column(name = "CREATED_BY", length = 50)
    private String createdBy;

    @Column(name = "UPDATED_BY", length = 50)
    private String updatedBy;

    @Column(name = "ISACTIVE")
    private Byte isactive;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent")
    private Integer parent;

}