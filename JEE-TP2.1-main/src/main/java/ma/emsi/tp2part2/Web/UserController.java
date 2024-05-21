package ma.emsi.tp2part2.Web;

import ma.emsi.tp2part2.Entities.User;
import ma.emsi.tp2part2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService UserService;

    @GetMapping("/User/{UserName}")
    public User User(@PathVariable String UserName){
        User User=UserService.findUserByUserName(UserName);
        return User;
    }
}
