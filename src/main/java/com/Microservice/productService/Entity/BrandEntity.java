package com.Microservice.productService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Brand")
public class BrandEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name",nullable = false,unique = true)
    private String name;

    @Column(name="dateCreated",nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate dateCreated;



    @Override
    public String toString() {
        return "BrandEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
