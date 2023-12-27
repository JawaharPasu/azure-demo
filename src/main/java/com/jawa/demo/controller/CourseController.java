package com.jawa.demo.controller;

import com.jawa.demo.dto.CourseDto;
import com.jawa.demo.entity.Course;
import com.jawa.demo.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@Validated
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/register",
            produces = "Application/json"
    )
    public ResponseEntity<String> registerCourses(@RequestBody @Valid CourseDto courseDto) {
        ModelMapper modelMapper = new ModelMapper();
        Course course = modelMapper.map(courseDto, Course.class);
        return ResponseEntity.of(Optional.of("Registered course with id = "
                + courseService.saveCourse(course).getCourseId()));
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/id/{id}",
            produces = "Application/json"
    )
    public Course getCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/"
    )
    public String home() {
        return "Hello there welcome!";
    }
}
