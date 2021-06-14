package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car = new Car("Lada", 2107);
      Car car1 = new Car("Reno", 456);
      Car car2 = new Car("Ford", 567);
      Car car3 = new Car("Nissan", 358);

      User user1 = new User("Gubka", "Bob", "GubkaB@mail.ru");
      User user = new User("Alladin", "Aliev", "Ali@mail.ru");
      User user2 = new User("Assole", "Red", "Ared2@mail.ru");
      User user3 = new User("Vasilii", "Gogol", "VasGog@mail.ru");

      user1.setCar(car);
      user.setCar(car1);
      user2.setCar(car3);
      user3.setCar(car2);

      userService.add(car);
      userService.add(car1);
      userService.add(car2);
      userService.add(car3);

      userService.add(user1);
      userService.add(user);
      userService.add(user2);
      userService.add(user3);


      List<User> users = userService.listUsers();
      for (User user4 : users) {
         System.out.println(user4);
         System.out.println();
      }

      System.out.println(userService.getCar("Lada", 2107));

      context.close();
   }
}
