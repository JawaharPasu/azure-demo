package com.jawa.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.jawa.demo.entity.Course;
import com.jawa.demo.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;
    @InjectMocks
    private CourseService courseService;

    @Test
    public void testCourseServiceSave() {
        Course course = Course.builder()
                .courseName("Science")
                .instructor("Noman")
                .email("noman@gmail.com")
                .build();
        Course expectedCourse = course;
        expectedCourse.setCourseId(Long.valueOf(1));
        when(courseRepository.save(course)).thenReturn(expectedCourse);
        Course actualCourse = courseService.saveCourse(course);

        assertEquals(expectedCourse,actualCourse);
        verify(courseRepository, times(1)).save(course);
    }

}
