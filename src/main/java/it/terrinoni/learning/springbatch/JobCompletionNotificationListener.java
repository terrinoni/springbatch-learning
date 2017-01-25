/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.terrinoni.learning.springbatch;

import it.terrinoni.learning.springbatch.model.Person;
import java.sql.ResultSet;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import static org.springframework.batch.core.BatchStatus.COMPLETED;

/**
 * The code in this class listens for when a job is BatchStatus.COMPLETED, and then uses
 * JdbcTemplate to inspect the results.
 *
 * @author Marco Terrinoni <marco.terrinoni@consoft.it>
 */
@Component
class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger LOG = LoggerFactory.getLogger(
            JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob (JobExecution jobExecution) {
        if (jobExecution.getStatus() == COMPLETED) {
            LOG.info("Job finished! Time to verify the results");

            List<Person> results = jdbcTemplate.query("SELECT first_name, last_name FROM people",
                    (ResultSet rs, int row) -> new Person(rs.getString(1), rs.getString(2)));
            results.forEach((p) -> {
                LOG.info("Found {}", p);
            });
        }
    }
}
