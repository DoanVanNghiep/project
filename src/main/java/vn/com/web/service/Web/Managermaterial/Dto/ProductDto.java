package vn.com.web.service.Web.Managermaterial.Dto;

import lombok.Builder;
import lombok.Value;
import vn.com.web.service.Web.Managermaterial.Domain.Category;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link vn.com.web.service.Web.Managermaterial.Domain.Product}
 */
@Builder
@Value
public class ProductDto implements Serializable {
    Integer id;
    String name;
    String description;
    String notes;
    String image;
    Category idcategory;
    Double price;
    Integer quatity;
    Instant createdDate;
    Instant updatedDate;
    String createdBy;
    String updatedBy;
    Byte isactive;
}