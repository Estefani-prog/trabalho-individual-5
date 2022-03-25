package entregafinal.forrester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class ForresterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForresterApplication.class, args);  

        //do your ReconTool stuff
    }
}

// @ComponentScan(basePackages = "recodepro1.traveller")
//public class SpringApplication {

	//public static void main(String[] args) {
		//SpringApplication.run(SpringApplication.class, args);
	//}

//}
