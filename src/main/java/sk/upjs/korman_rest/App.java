package sk.upjs.korman_rest;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.InitBinder;

import javafx.stage.Stage;
import me.duras.korman.DaoFactory;
import me.duras.korman.Database;



@SpringBootApplication
public class App {
	
	static Database db;
	
	// pri starte je potrebne zaviest databazu
	public static void init() {
		db = new Database();
        db.connect();
        DaoFactory.INSTANCE.setJdbcTemplate(db.getTemplate());
	}
	
    public static void main( String[] args ){
    	

    	   
        App.init();    
        SpringApplication.run(App.class, args);
    }
}