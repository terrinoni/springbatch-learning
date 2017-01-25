/**
 * Author:  Marco Terrinoni <marco.terrinoni@consoft.it>
 * Created: Jan 25, 2017
 */

DROP TABLE people IF EXISTS;

CREATE TABLE people (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(30)
);