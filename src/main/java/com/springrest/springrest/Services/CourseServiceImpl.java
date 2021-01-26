package com.springrest.springrest.Services;

import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{
    List<Course> list;
    public CourseServiceImpl()
    {
        list=new ArrayList<>();
        list.add(new Course(123,"Java Course","this is java course"));
        list.add(new Course(125,"spring boot course","This is spring boot course"));
    }

    @Override
    public List<Course> getCourses()
    {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        Course c=null;
        for (Course course:list)
        {
            if (course.getId()==courseId)
            {
                c=course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        list.forEach(course1 -> {
            if (course1.getId()==course.getId()){
                course1.setTittle(course.getTittle());
                course1.setDescription(course.getDescription());
            }
        });
        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {
        list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
    }

}
