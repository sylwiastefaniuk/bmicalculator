package pl.kodu.akademia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kodu.akademia.model.Person;
import pl.kodu.akademia.repository.PersonsRepository;

import java.util.List;
import java.util.Random;

@Controller
public class FirstController {
    @RequestMapping("/index")
    public String hello() {
        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchedResultById() {
        return "search";
    }

    @RequestMapping(value = "/bmiResult", method = RequestMethod.GET)
    public String result() {
        return "bmiResult";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String newPersonSubmit(@RequestParam() double growthNewPerson,
                                  @RequestParam() double weightNewPerson,
                                  @RequestParam() String gender, Model model) {

        double bmi = ((weightNewPerson/ (growthNewPerson * 2)) * 100);
        bmi = Math.round(bmi * 100) / 100;
        Random random = new Random();
        int id = random.nextInt(8999) + 1000;
        Person newPerson = new Person(id, growthNewPerson, weightNewPerson, gender, bmi);
        model.addAttribute("bmiResult", newPerson);

        PersonsRepository.addNewPerson(newPerson);
        return "bmiResult";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchFormSubmit(@RequestParam() int id, Model model) {
        List<Person> wyszukanaOsoba = PersonsRepository.getPersonsById(id);
        model.addAttribute("savedPersonInputs", wyszukanaOsoba);
        return "savedInputs";
    }
}
