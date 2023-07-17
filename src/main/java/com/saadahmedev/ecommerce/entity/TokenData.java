package com.saadahmedev.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "token_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenData {
    @Id
    private String token;
}
