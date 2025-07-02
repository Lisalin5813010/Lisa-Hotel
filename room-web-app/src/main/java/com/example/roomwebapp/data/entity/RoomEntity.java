package com.example.roomwebapp.data.entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="ROOMS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ROOM_ID")
    private UUID roomId;
    @Column(name="NAME")
    private String name;
    @Column(name="NUMBER")
    private String number;


    @Column(name="BED_INFO")
    private String bedInfo;

}
