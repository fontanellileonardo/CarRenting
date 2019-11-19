import java.util.logging.Level;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.service.spi.ServiceException;

// Open only one connection with the DB
public class DBConnection {
	private static DBConnection instance;
	public static EntityManagerFactory factory;
	
	private DBConnection() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		try {
			factory = Persistence.createEntityManagerFactory("CarRenting");
		} catch (ServiceException ex) {
			System.err.println("Unable to establish a connection to MySQL database");
		}
	}
	
	public static DBConnection getInstance() {
	    if(instance == null){
	        synchronized (DBConnection.class) {
	            if(instance == null){
	                instance = new DBConnection();
	            }
	        }
	    }
	    return instance;
	}
	
}
