package com.razin.vadim.util;

import com.razin.vadim.dao.PersonDAO;
import com.razin.vadim.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component // хотим чтобы Spring сделал внедрение PersonDAO за нас
public class PersonValidator implements Validator {
    // так как обращаться будем к БД нужно внедрить наш контролле PersonDAO

    private final PersonDAO personDAO;

    @Autowired // Spring может и без Autowired, но лучше явно указывать, что мы хотим это
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @Override
    public boolean supports(Class<?> clazz) { // необходимо указать на объектах какого класса использовать
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) { // будет вызываться на объекте класса Person
        Person person = (Person)target;
        // посмотреть, есть ли человек с таким же email'ом в БД

        if (personDAO.show(person.getEmail()).isPresent()) {
            // рекомендуется не использовать проверку на null-> Optional (java 8)
            errors.rejectValue("email", "", "This email is already taken");
            // в первый аргумент кладем поле, где ошибка, 2-ой код ошибки, 3-ий сообщение об ошибке
        }
            //
    }
}
