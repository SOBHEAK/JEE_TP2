package ma.emsi.tp2part2.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.emsi.tp2part2.Entities.Role;
import ma.emsi.tp2part2.Entities.User;
import ma.emsi.tp2part2.Repositories.RoleRepository;
import ma.emsi.tp2part2.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository UserRepository;
    private RoleRepository RoleRepository;

    @Override
    public User addNewUser(User User) {
        User.setUserId(UUID.randomUUID().toString());
        return UserRepository.save(User);
    }

    @Override
    public Role addNewRole(Role Role) {
        return RoleRepository.save(Role);
    }

    @Override
    public User findUserByUserName(String UserName) {
        return UserRepository.findByUsername(UserName);
    }

    @Override
    public Role findRoleByRoleName(String RoleName) {
        return RoleRepository.findByRoleName(RoleName);
    }

    @Override
    public void addRoleToUser(String UserName, String RoleName) {

        User User = findUserByUserName(UserName);
        Role Role = findRoleByRoleName(RoleName);
        if (User.getRoles()!=null) {
            User.getRoles().add(Role);
            Role.getUsers().add(User);
        }
        //UserRepository.save(User);
    }

    @Override
    public User authenticate(String UserName, String Password) {

        User User=UserRepository.findByUsername(UserName);
        if(User==null) throw new RuntimeException("Bad credentials");
        if(User.getPassword().equals(Password)){
        return User;
    }
        throw new RuntimeException("Bad credentials");
}
}
