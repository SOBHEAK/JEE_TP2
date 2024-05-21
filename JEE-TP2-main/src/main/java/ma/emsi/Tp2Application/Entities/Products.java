package ma.emsi.Tp2Application.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Products {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    private double Price;
    private int Quantity;

}
