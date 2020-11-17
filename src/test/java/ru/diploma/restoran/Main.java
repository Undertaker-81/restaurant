package ru.diploma.restoran;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.diploma.restoran.controller.RestController;
import ru.diploma.restoran.model.Restoran;
import ru.diploma.restoran.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 15.11.2020
 */
public class Main {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml", "spring/spring-mvc.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            RestController adminUserController = appCtx.getBean(RestController.class);
          //  List<User> userList = adminUserController.getAll();
         //   userList.forEach(System.out::println);
            List<User> users = adminUserController.getAllByRestoran(100019);
            users.forEach(System.out::println);
            System.out.println();
            System.out.println(adminUserController.getRestoran(100019));
        }
    }
}
