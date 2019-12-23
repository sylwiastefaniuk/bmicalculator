package pl.kodu.akademia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kodu.akademia.model.Person;
import pl.kodu.akademia.model.Sex;
import pl.kodu.akademia.repository.PersonsRepository;
import pl.kodu.akademia.services.BmiService;

import java.util.List;
import java.util.Random;

@Controller
public class FirstController {

    @Autowired
    BmiService bmiService;

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
                                  @RequestParam() Sex sex, Model model) {

        double bmi = ((weightNewPerson / (growthNewPerson * 2)) * 100);
        bmi = Math.round(bmi * 100) / 100;
        Person newPerson = new Person(10, growthNewPerson, weightNewPerson, sex, bmi);
        model.addAttribute("bmiResult", newPerson);
        this.bmiService.savePerson(newPerson);
        return "bmiResult";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchFormSubmit(@RequestParam() int id, Model model) {
        Person searchedPerson = bmiService.getPersonById(id);
        model.addAttribute("savedPersonInputs", searchedPerson);
        return "savedInputs";
    }
}
