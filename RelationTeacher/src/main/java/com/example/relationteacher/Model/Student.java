package com.example.relationteacher.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(10)")
    private String name;
    @Column(columnDefinition = "int not null")
    private Integer age;
    @Column(columnDefinition = "varchar(10)")
    private String  major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;


}
