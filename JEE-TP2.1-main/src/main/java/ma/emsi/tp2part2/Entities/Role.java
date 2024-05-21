package ma.emsi.tp2part2.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long Id;

    @Column(name = "Description")
    private String Desc;

    @Column(length = 20, unique = true)
    private String RoleName;

    @ManyToMany(fetch = FetchType.EAGER)
    //@JoinTable(name = "Users_Roles")

    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<User> Users=new ArrayList<>();
}
