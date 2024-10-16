package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseService implements ICourseService{

	List<Course> list;
	
	public CourseService() {
		list = new ArrayList<>();
		list.add(new Course(143, "Java Core", "It is core Java Course"));
		list.add(new Course(150, "Adv Java", "Its an advance Java Course"));
	}
 	@Override
	public List<Course> getCourses() {		
		return list;
	}
	
 	@Override
	public Course getCourse(long courseId) {
		Course cur = null;
		for (Course ch : list) {
			if (ch.getId() == courseId) {
				cur = ch;
				break;
			}
		}
		return cur;
	}
 	
	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}
	@Override
	public Course updateCourse(long courseId, Course course) {
		for (int i = 0; i < list.size(); i++) {
			Course ch = list.get(i);
			if (ch.getId() == courseId) {
				list.set(i, course);
				return course;
			}
		}
		return null;
	}
	@Override
	public ResponseEntity<HttpStatus> deleteCourse(long courseId) {
		for (int i = 0; i < list.size(); i++) {
			Course ch = list.get(i);
			if (ch.getId() == courseId) {
				list.remove(i);
				return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
