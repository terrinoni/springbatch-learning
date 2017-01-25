/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.terrinoni.learning.springbatch;

import it.terrinoni.learning.springbatch.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * Simple transformer that converts the name to uppercase, following the common batch paradigm that
 * ingest data, transform it, and then pipe it out.
 * The implementation of ItemProcessor<I, O> Spring Batch's interface ease such paradigm.
 *
 * @author Marco Terrinoni <marco.terrinoni@consoft.it>
 */
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger LOG = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process (final Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person resultPerson = new Person(firstName, lastName);

        LOG.info("Successfully converted {} into {}", person, resultPerson);

        return resultPerson;
    }
}
