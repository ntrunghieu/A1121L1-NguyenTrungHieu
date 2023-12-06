create database test;

CREATE TABLE parent (
    id INT NOT NULL,
    PRIMARY KEY (id)
) ENGINE=INNODB;

select * from parent;
delete from parent where id =2;


CREATE TABLE child (
    id INT, 
    parent_id INT,
    INDEX par_ind (parent_id),
    FOREIGN KEY (parent_id) REFERENCES parent(id)
	ON DELETE CASCADE
) ENGINE=INNODB;

CREATE TABLE childs (
    id INT, 
    parent_id INT,
    FOREIGN KEY (parent_id) REFERENCES parent(id)
	ON DELETE CASCADE
) ENGINE=INNODB;
select * from child;
delete from child where parent_id = 1;


INSERT INTO child(id,parent_id ) VALUES 
(1,1),
(2,2),
(3,3);

  
  

CREATE TABLE child_delete (
    id INT, 
    parent_id INT,
    INDEX par_ind (parent_id),
    FOREIGN KEY (parent_id) REFERENCES parent(id)
) ENGINE=INNODB;

INSERT INTO child_delete(id,parent_id ) VALUES 
(1,1),
(2,2),
(3,3);
select * from child_delete;
delete from child_delete where parent_id = 1;

INSERT INTO parent(id) VALUES 
  (1),
  (2),
  (3),
  (4);