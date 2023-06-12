package org.example;

import org.example.controller.PersonController;
import org.example.db.DB;
import org.example.model.Feedbacks;
import org.example.model.Person;
import org.example.repositories.FeedbackRepository;
import org.example.repositories.PersonRepository;
import org.example.service.FeedbackService;
import org.example.service.PersonService;

public class Main {
    public static void main(String[] args) {

        FeedbackRepository FeedbackRepository = new FeedbackRepository(DB.getConnection());
        PersonRepository personRepository = new PersonRepository(DB.getConnection());
        PersonService personService = new PersonService(personRepository);
        FeedbackService feedbackService = new FeedbackService(FeedbackRepository);


        var all1 = personService.getPeopleById(62).getName();
        var all = feedbackService.getFeedbacksById(62, 10).getFeedbacksText();
        var all4 = feedbackService.getFeedbacksById(62, 1).getFeedbacksText();

        System.out.println(all1);

        System.out.println("______________________________________________________");

        System.out.println(all);

        System.out.println("______________________________________________________");

        System.out.println(all4);






    }
}