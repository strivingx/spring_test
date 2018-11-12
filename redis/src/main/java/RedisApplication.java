import com.yyy.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApplication {
	@Autowired
 UserDao userDao;
	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}
}
