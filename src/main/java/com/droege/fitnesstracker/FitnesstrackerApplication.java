package com.droege.fitnesstracker;

import com.droege.fitnesstracker.model.User;
import com.droege.fitnesstracker.model.Workout;
import com.droege.fitnesstracker.repository.ContactsMasterRepo;
import com.droege.fitnesstracker.repository.WorkoutRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class FitnesstrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnesstrackerApplication.class, args);
	/*
		ConfigurableApplicationContext ctxt = SpringApplication.run(FitnesstrackerApplication.class);

		ContactsMasterRepo bean = ctxt.getBean(ContactsMasterRepo.class);

		WorkoutRepository workoutBean = ctxt.getBean(WorkoutRepository.class);

		//ContactsMasterEntity entity = bean.findByContactName("Thomas");

		//ContactsMasterEntity entity = bean.findByContactNameAndContactNumber("Claudia", 1234L);

//		List<ContactsMasterEntity> entities = bean.findAllByContactName("Claudia");
//		System.out.println(entities);

		User user = new User();
		user.setUserId(1);
		user.setUserName("dontom");
		user.setFirstName("thomas");
		user.setLastName("dröge");
		user.setEmail("thomasdroege@gmx.de");
		user.setPassword("12345678");

		List<Workout> workouts =  workoutBean.findAllByUser(user);
		ctxt.close();
		System.out.println("Test");
		//System.out.println(workouts);
*/
	}

}
