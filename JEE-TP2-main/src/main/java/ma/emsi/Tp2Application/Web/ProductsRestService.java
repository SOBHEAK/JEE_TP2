package ma.emsi.Tp2Application.Web;

import ma.emsi.Tp2Application.Entities.Products;
import ma.emsi.Tp2Application.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsRestService {

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/products")
    public List<Products> products(){
        return productsRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Products findProducts(@PathVariable Long Id){
        Products products = productsRepository.findById(Id).orElse(null);
        return products;
    }
}


