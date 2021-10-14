package com.hotelbooking.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "room_feature")
public class RoomFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "feature_id")
    private Long id;

    @Column(name = "feature_name", unique = true, nullable = false)
    private String name;
}
