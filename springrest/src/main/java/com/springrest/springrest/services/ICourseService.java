package com.springrest.springrest.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springrest.springrest.entities.Course;

public interface ICourseService {
	 public List<Course> getCourses();
	 public Course getCourse(long courseId);
	 public Course addCourse(Course course);
	 public Course updateCourse(long courseId, Course course);
	 public ResponseEntity<HttpStatus> deleteCourse(long courseId);
}
