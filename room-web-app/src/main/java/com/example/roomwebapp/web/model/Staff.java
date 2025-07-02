package com.example.roomwebapp.web.model;

import com.example.roomwebapp.data.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    private UUID id;
    private String firstname;
    private String lastname;
    private String position;
}
