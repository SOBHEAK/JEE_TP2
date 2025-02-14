package ma.emsi.hospital.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity

@Data @NoArgsConstructor @AllArgsConstructor

public class Consultation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Date DateConsultation;
    private String Rapport;

    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private RendezVous RendezVous;
}
