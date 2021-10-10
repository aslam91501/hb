package com.hotelbooking.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "addon")
public class Addon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addon_id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;
}
