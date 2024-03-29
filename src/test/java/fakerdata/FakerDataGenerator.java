package fakerdata;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {

	@Test
	void testGenerateDummyData() {
		
		Faker f=new Faker();
		String fullname=f.name().fullName();
		String firstname=f.name().firstName();
		String lastname=f.name().lastName();
		
		String username=f.name().username();
		String password=f.internet().password();
		String phoneno=f.phoneNumber().cellPhone();
		String email=f.internet().safeEmailAddress();
		
		System.out.println("Fullname"+fullname);
		System.out.println("Firstname"+firstname);
		System.out.println("Lastname"+lastname);
		System.out.println("Username"+username);
		System.out.println("Password"+password);
		System.out.println("Phoneno"+phoneno);
		System.out.println("Email"+email);
		
	}
}
