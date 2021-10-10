package com.hotelbooking.api.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "room")
@Data
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private Long id;

    @Column(name="room_no", nullable = false, unique = true)
    private int roomNumber;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @Column(name = "room_price")
    private float price;

    @Column(name = "room_status")
    @Enumerated(EnumType.STRING)
    private RoomStatus status;    

    @ManyToMany
    @JoinTable(
        name = "room_feature",
        joinColumns = @JoinColumn(name="room_id"),
        inverseJoinColumns = @JoinColumn(name="feature_id")
    )
    private Set<Feature> features;
}
