package ma.emsi.tp2part2.Repositories;

import ma.emsi.tp2part2.Entities.Role;
import ma.emsi.tp2part2.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByRoleName(String RoleName);
}
