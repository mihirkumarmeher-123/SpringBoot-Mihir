package com.myprojects.product.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data //for Setter , Getter
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// To generate Id automatically
    private Long id;
    private String username;
    private String password;
}
