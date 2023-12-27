package com.jawa.demo.entity;

import lombok.*;

import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long courseId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "instructor")
    private String instructor;
    @Column(name = "email")
    private String email;
}
