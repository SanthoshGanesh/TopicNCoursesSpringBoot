package io.santysboot.sbootquickstart.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.santysboot.sbootquickstart.topic.Topic;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	

	public List<Course> getAllCourses(String topicId)
	{
		//return topics;
		List<Course> courses=new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);   //check lambda in java8
		return courses;
	}
	
	public Optional<Course> getCourse(String id)
	{
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}

	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepository.save(course); //check if the data already exists, If YES,updates the given row with provided topic, ELSE adds new row(addtopic)
		
		
	}

	

	public void deleteCourse(String id) {
		// TODO Auto-generated method stub
		//topics.removeIf(t -> t.getId().equals(id)); -- Lambda in Java8
		courseRepository.deleteById(id);
	}

	
}
