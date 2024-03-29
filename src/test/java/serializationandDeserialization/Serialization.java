package serializationandDeserialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialization {

	//@Test
	void convertPojoToJson() throws JsonProcessingException {
		
		Student obj=new Student();
		
		obj.setName("Scott");
		obj.setLocation("France");
		obj.setPhone("123456");
		
		String courseArr[]= {"C","C++"};
		obj.setCourses(courseArr);
		
		//convert java object------->json object(serilzation)
		ObjectMapper objmap=new ObjectMapper();
		String jsondata = objmap.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		System.out.println(jsondata);
	}
	
	@Test
	void convertJsonToPojo() throws JsonMappingException, JsonProcessingException {
		
		String jsondata="{\r\n"
				+ "  \"name\" : \"Scott\",\r\n"
				+ "  \"location\" : \"France\",\r\n"
				+ "  \"phone\" : \"123456\",\r\n"
				+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
				+ "}";
		
		ObjectMapper objmap=new ObjectMapper();
		Student stuPojo = objmap.readValue(jsondata, Student.class);
		
		System.out.println("Name:"+stuPojo.getName());
		System.out.println("Location:"+stuPojo.getLocation());
		System.out.println("Phone No:"+stuPojo.getPhone());
		System.out.println("Course 1:"+stuPojo.getCourses()[0]);
		System.out.println("Course 2:"+stuPojo.getCourses()[1]);
	}
}
