package com.example.kafka;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Path("/students")
@Produces("application/json")
public class StudentResource {

	Map<String, Object> props;

	@PostConstruct
	public void intializeConfig() {
		props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "my-cluster-kafka-bootstrap:9092");
// config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "kafka");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	}

	@Autowired
	private KafkaTemplate<String, Student> kafkaTemplate;
	private static final String TOPIC = "kafkaexample";

	@GET
	@Path("/{stdid}")
	public Student getStudentDetail(@PathParam("stdid") String stdid) {
//    	System.out.println("stdid from angular is "+stdid);
//        return repo.findByStdid(stdid);
		return null;
	}

	@GET
	@Path("/authors")
	public String getAuthorNames() {
		// System.out.println("stdid from angular is "+stdid);
		return "Arkansas";
	}

	@GET

	public List<String> getStudentIds() throws JsonMappingException, JsonProcessingException {
//        Iterable<Student> students = repo.findAll();
//        List<String> idList = new ArrayList<String>();
//        for(Student s : students) {
//            idList.add(s.getStdid());

		// kafkaTemplate.send(TOPIC, student);

		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		List<String> topics = new ArrayList<>();
		topics.add("kafkaexample");
		consumer.subscribe(topics);
		System.out.println("kafkaexample");
		List<PartitionInfo> partitionInfoList=consumer.partitionsFor(TOPIC);
	List<TopicPartition> topicPartitions=new ArrayList<>();
	
	
	for(PartitionInfo partitionInfo: partitionInfoList)
	{
		TopicPartition topicPartition=new TopicPartition(TOPIC,partitionInfo.partition());
		topicPartitions.add(topicPartition);
	}
		consumer.seekToBeginning(topicPartitions);
		
		ConsumerRecords<String, String> cRecords = consumer.poll(Duration.of(10, ChronoUnit.SECONDS));
		List<String> studentList = new ArrayList<>();
		ObjectMapper om = new ObjectMapper();
		for (ConsumerRecord<String, String> record : cRecords) {

			Student s1 = om.readValue(record.value(), Student.class);
			studentList.add(s1.getStdid());
			System.out.println(s1);
		}
		consumer.close();
		System.out.println("I am inside GET");
		// return idList;
		return studentList;
	}

	@POST
	@Path("/kafkapost")
	@Consumes("application/json")
	public void create(Student student) {
		// System.out.println("student from angular "+student);
		/*
		 * System.out.println("student from angular "+student.getStdname());
		 * List<String> idList = new ArrayList<String>(); try { repo.save(student);
		 * Iterable<Student> students = repo.findAll();
		 * 
		 * if(students!=null) { for(Student s : students) { idList.add(s.getStdid());
		 * 
		 * 
		 * } }
		 */
		System.out.println("THE NAME IS " + student.getStdname());

		kafkaTemplate.send(TOPIC, student);

		System.out.println("I am inside POST");

		// return idList;

	}

}
