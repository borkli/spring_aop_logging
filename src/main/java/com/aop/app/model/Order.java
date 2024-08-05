package com.aop.app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "`order`")
@Accessors(chain = true)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String details;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
