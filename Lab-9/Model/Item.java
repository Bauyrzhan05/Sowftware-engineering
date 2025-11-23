package com.example.demo.Lab_9.Model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "items")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id")
    private Country manufacturer;
}
