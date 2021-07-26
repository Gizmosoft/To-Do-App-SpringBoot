DROP TABLE IF EXISTS items;
CREATE TABLE IF NOT EXISTS items (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  title varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;


INSERT INTO items (id, title) VALUES
	(1, 'TESTItem');

INSERT INTO items (id, title) VALUES
	(2, 'NewItem');
commit;