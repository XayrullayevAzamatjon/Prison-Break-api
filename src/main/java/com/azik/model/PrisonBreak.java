package com.azik.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrisonBreak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "actor")
    private String actor;
    @Column(name = "prison_characters")
    private String character;
    @Column(name = "about")
    private String about;
//    private byte[] picture;
}
