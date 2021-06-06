package io.santysboot.sbootquickstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics=new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring framework","Spring framework desc"),
			new Topic("AWS","AWS framework","AWS framework desc"),
			new Topic("Python","Python framework","Python framework desc")
			));

	public List<Topic> getAllTopics()
	{
		//return topics;
		List<Topic> topics=new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);   //check lambda in java8
		return topics;
	}
	
	public Optional<Topic> getTopic(String id)
	{
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}

	public void updateTopic(Topic topic, String id) {
		// TODO Auto-generated method stub
		topicRepository.save(topic); //check if the data already exists, If YES,updates the given row with provided topic, ELSE adds new row(addtopic)
		
		
	}

	

	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		//topics.removeIf(t -> t.getId().equals(id)); -- Lambda in Java8
		topicRepository.deleteById(id);
	}

	
}
