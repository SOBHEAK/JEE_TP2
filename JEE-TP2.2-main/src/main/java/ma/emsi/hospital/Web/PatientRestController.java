package ma.emsi.hospital.Web;

import ma.emsi.hospital.Entities.Patient;
import ma.emsi.hospital.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {

    @Autowired
    private PatientRepository PatientRepository;

    @GetMapping("/Patient")
    public List<Patient> PatientList(){
        return PatientRepository.findAll();
    }
}
