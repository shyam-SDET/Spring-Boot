package com.springrest.springrest.controller;

import com.springrest.springrest.Services.CourseService;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Mycontroller {
    @Autowired
    private CourseService courseService;
    @GetMapping("/home")
    public String home()
    {
        return "This is Home Page Welcome to all of you guess ";
    }
    // return all courses using get request
    @GetMapping(value = "/courses")
    public List<Course> getCourses()
    {
        return this.courseService.getCourses();
    }
    // return single course using get+courseId request
    @GetMapping(value = "/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId)
    {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //add course using post request
    @PostMapping(value = "/courses")
    public Course addCourse(@RequestBody Course course)
    {
        return this.courseService.addCourse(course);
    }

    //update course using put Request
    @PutMapping(value = "/courses")
    public Course updateCourse(@RequestBody Course course)
    {
        return this.courseService.updateCourse(course);
    }

    //delete the course using delete request
    @DeleteMapping(value = "/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
    {
        try
        {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
