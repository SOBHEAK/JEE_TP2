package ma.emsi.tp2part2;

import ma.emsi.tp2part2.Entities.Role;
import ma.emsi.tp2part2.Entities.User;
import ma.emsi.tp2part2.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Tp2Part2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp2Part2Application.class, args);
	}

	@Bean
	CommandLineRunner start(UserService UserService) {
		return args -> {
			User U = new User();
			U.setUsername("User1");
			U.setPassword("123456");
			UserService.addNewUser(U);

			User U2 = new User();
			U2.setUsername("Admin");
			U2.setPassword("123456");
			UserService.addNewUser(U2);

			Stream.of("Student", "User", "Admin").forEach(r -> {

				Role Role1 = new Role();
				Role1.setRoleName(r);
				UserService.addNewRole(Role1);
			});

			UserService.addRoleToUser("User1", "Student");
			UserService.addRoleToUser("User1", "User");
			UserService.addRoleToUser("Admin", "User");
			UserService.addRoleToUser("Admin", "Admin");

			try {
				User User = UserService.authenticate("User1", "123456");
				System.out.println(User.getUserId());
				System.out.println(User.getUsername());
				System.out.println("Roles=>");
				User.getRoles().forEach(r -> {
					System.out.println("Roles=>" + r.toString());
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		};
	}
