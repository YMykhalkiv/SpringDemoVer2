package com.example.springdemover2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "dota_character")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DotaCharacter {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "health")
    private int health;
    @Basic
    @Column(name = "damage")
    private int damage;
    @Basic
    @Column(name = "armor")
    private int armor;

}
