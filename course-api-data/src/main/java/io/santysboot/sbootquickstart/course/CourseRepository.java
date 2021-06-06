package io.santysboot.sbootquickstart.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface CourseRepository extends CrudRepository<Course, String>{
	
//	public List<Course> findByName(String name);
//	
//	public List<Course> findByDescription(String description);
	
	public List<Course> findByTopicId(String topicId);
	//getAlltopics()
	//getTopic(String id)
	//updateTopic(Topic t,String id)
	//deleteTopic(String id)
	
	
	
}
