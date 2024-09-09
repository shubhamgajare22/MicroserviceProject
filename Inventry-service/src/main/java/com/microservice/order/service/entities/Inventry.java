package com.microservice.order.service.entities;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_inventry")
@Getter
@Setter
@Builder
public class Inventry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String skuCode;

    private Integer quantity;


}






































