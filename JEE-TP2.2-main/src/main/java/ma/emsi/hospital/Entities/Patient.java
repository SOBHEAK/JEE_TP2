package ma.emsi.hospital.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity

@Data @NoArgsConstructor @AllArgsConstructor

public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String Name;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean Malade;

    @OneToMany(mappedBy = "Patient",fetch = FetchType.LAZY)
    private Collection<RendezVous> RendezVous;
}
