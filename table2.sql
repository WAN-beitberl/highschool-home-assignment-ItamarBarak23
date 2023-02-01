CREATE TABLE sima.highschool_friendships (
  id INT NOT NULL,
  friend_id INT NULL,
  other_friend_id INT NULL,
  PRIMARY KEY (id),
  foreign key (friend_id) references highschool(id),
  foreign key (other_friend_id) references highschool(id));