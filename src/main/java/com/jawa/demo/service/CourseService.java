package com.jawa.demo.service;

import com.jawa.demo.entity.Course;
import com.jawa.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourse(Long id) {
        return courseRepository.findById(id).get();
    }
}
