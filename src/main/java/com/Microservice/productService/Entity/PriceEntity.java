package com.Microservice.productService.Entity;

import io.swagger.models.auth.In;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name="prices")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="price")
    private Float price;

    @ManyToOne
    @JoinColumn(name="productId")
    private ProductEntity product;

    @Column(name="dateCreated")
    @Temporal(TemporalType.DATE)
    private LocalDate dateCreated;

    @Override
    public String toString() {
        return "PriceEntity{" +
                "id=" + id +
                ", price=" + price +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
