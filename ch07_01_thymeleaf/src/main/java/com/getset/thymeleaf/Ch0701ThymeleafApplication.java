package com.getset.thymeleaf;

import com.getset.thymeleaf.domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class Ch0701ThymeleafApplication {

    @RequestMapping("/")
    public String index(Model model) {
        Person single = new Person("aa", 11);

        List<Person> people = new ArrayList<>();
        people.add(new Person("bb", 22));
        people.add(new Person("cc", 33));
        people.add(new Person("dd", 44));

        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);

        return "index";
    }

	public static void main(String[] args) {
		SpringApplication.run(Ch0701ThymeleafApplication.class, args);
	}
}
