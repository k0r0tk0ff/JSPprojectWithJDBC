
--------------------  Creating database -------------------------

create TABLE clients (
 id serial PRIMARY KEY,
 name VARCHAR(20),
 password VARCHAR(20),
 role VARCHAR(20)
);

 /*
 Create table "user`s pets"
 user_id - foreign key
 */
create table pets (
 petId serial primary key,
 nick varchar(20),
 type varchar(20),
 user_id int not null references clients(id)
);

 -- Create exemplar of client

INSERT into clients (name) VALUES ('mpgonch1');

 -- Create mpgonch1`s pet -> Tomcat (type is cat)

INSERT into pets (user_id, nick, type) VALUES ('1', 'Tomcat', 'cat');

 -- Create mpgonch1`s pet -> PussyCat (type is cat)

INSERT into pets (user_id, nick, type) VALUES ('1', 'PussyCat', 'cat');

 -- select colums from table client with alias client.
 -- alias may be use with join

UPDATE clients as client set password = 'asdfgh123$'
WHERE client.name = 'mpgonch1';

UPDATE clients as client set email = 'kotiki@email.ru'
WHERE client.name = 'mpgonch1';

INSERT into clients (name, password, email, role) VALUES ('a','a','a@email.com','ROLE_ADMIN');

INSERT into pets (user_id, nick, type) VALUES ('1', 'PussyCat', 'cat');

 -------------------------   SELECTING  &  Updating ---------------------------
 -- show all in table clients

SELECT * FROM public.clients
ORDER BY id ASC;

   -- add column

ALTER TABLE clients ADD COLUMN role VARCHAR(20);
ALTER TABLE clients ADD COLUMN password VARCHAR(20);
ALTER TABLE clients ADD COLUMN email VARCHAR(20);


SELECT * FROM clients as client;

 -- with "if"

select * from clients as customer WHERE customer.name = 'mpgonch1';

 -- select with output from two table.
 -- show table with first column "pet`s nick"
 -- and second column "user`s name"

SELECT pet.nick, customer.name
FROM pets as pet
INNER JOIN clients as customer
on customer.id = pet.user_id;

 -- update data
 -- in table pets find pet with name 'Tomcat' and set petId to '1'

UPDATE pets as pet set pet.petId = '1'
WHERE pet.nick = 'Tomcat';

UPDATE clients as client set name = 'mpgonch1'
WHERE client.name = 'Tomcat';

 -- update data
 -- in table pets find pet with name 'Tomcat' and rename to 'Dodya'

UPDATE pets as pet set nick = 'Dodya'
WHERE pet.nick = 'Tomcat';

 -- set new value
UPDATE clients set role = 'asdf'
WHERE name = 'mpgonch1';

 -- delete
 -- if we want to delete client, previos we must delete his pets!!!
 -- but framework HIBERNATE may it

DELETE from pets as pet
where pet.user_id = '1';

DELETE from clients as customer
where customer.name = 'mpgonch1';


