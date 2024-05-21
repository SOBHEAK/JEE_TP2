package ma.emsi.tp2part2.Service;

import ma.emsi.tp2part2.Entities.Role;
import ma.emsi.tp2part2.Entities.User;

public interface UserService {

    User addNewUser(User User);
    Role addNewRole(Role Role);
    User findUserByUserName(String UserName);
    Role findRoleByRoleName(String RoleName);

    void addRoleToUser(String UserName, String RoleName);
    User authenticate(String UserName, String Password);
}
