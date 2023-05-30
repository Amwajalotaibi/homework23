package com.example.relationteacher.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(10)")
    private String area;
    @Column(columnDefinition = "varchar(10) not null")
    private String street;
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;



    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
