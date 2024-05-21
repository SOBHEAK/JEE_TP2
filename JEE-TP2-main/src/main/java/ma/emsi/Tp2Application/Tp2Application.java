package ma.emsi.Tp2Application;

import ch.qos.logback.core.net.SyslogOutputStream;
import ma.emsi.Tp2Application.Entities.Products;
import ma.emsi.Tp2Application.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Tp2Application implements CommandLineRunner {

    @Autowired
    private ProductsRepository ProductsRepository;
    public static void main(String[] args) {

        SpringApplication.run(Tp2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

      ProductsRepository.save(new Products(null,"Computer",4300,3));
      ProductsRepository.save(new Products(null,"Printer",1200,4));
      ProductsRepository.save(new Products(null,"SmartPhone",3200,32));
        List<Products> Products = ProductsRepository.findAll();
        Products.forEach(p->{
            System.out.println(p.toString());
        });

        Products products=ProductsRepository.findById(Long.valueOf(1)).get();
        System.out.println("***********");
        System.out.println(products.getId());
        System.out.println(products.getName());
        System.out.println(products.getQuantity());
        System.out.println("***********");

        System.out.println("--------------");

        List<Products> productsList = ProductsRepository.findByNameContains("C");
        productsList.forEach(p->{
            System.out.println(p);
        });

        System.out.println("--------------");
        List<Products> productsList2 = ProductsRepository.search("%C%");
        productsList2.forEach(p->{
            System.out.println(p);
        });

        System.out.println("--------------");
        List<Products> productsList3 = ProductsRepository.searchByPrice(3000);
        productsList3.forEach(p->{
            System.out.println(p);
        });
    }
}
