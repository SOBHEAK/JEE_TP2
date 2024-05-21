package ma.emsi.tp2part2.Repositories;

import ma.emsi.tp2part2.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    User findByUsername(String UserName);
}
