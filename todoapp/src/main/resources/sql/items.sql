DROP TABLE IF EXISTS items;
CREATE TABLE IF NOT EXISTS items (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  title varchar(35) DEFAULT NULL,
  done int(11) DEFAULT 0,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;


INSERT INTO items (id, title, done) VALUES
	(1, 'TESTItem', 0);
commit;