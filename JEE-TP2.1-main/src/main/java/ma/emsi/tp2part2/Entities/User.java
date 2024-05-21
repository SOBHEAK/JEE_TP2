package ma.emsi.tp2part2.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    private String UserId;

    @Column(name = "User_Name", unique = true, length = 20)
    private String Username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String Password;

    @ManyToMany(mappedBy = "Users", fetch = FetchType.EAGER)
    private List<Role> Roles=new ArrayList<>();
}
