CREATE database web_chat;

CREATE table information
(
  Id          serial primary key,
  Name        varchar(255),
  Surname     varchar(255),
  Patronymic  varchar(255),
  Phone       varchar(255),
  DateOfBirth varchar(255),
  Gender      varchar(255),
  Country     varchar(255),
  AboutMySelf varchar(5000)
);

CREATE table groups
(
  Id    serial primary key,
  Class varchar(255)
);

CREATE table users
(
  Id             serial primary key,
  Nickname       varchar(255),
  Email          varchar(255),
  Password       varchar(255),
  Information_id integer references information (id)
);

CREATE table feedback
(
  Id      serial primary key,
  Name    varchar(255),
  Email   varchar(255),
  Message varchar(5000)
);

CREATE table feedback_user
(
  User_id     integer references users (id),
  Feedback_id integer references feedback (id)
);

CREATE table user_group
(
  User_id  integer references users (id),
  Group_id integer references groups (id)
);

Insert into groups(class)
values ('Cartoon lovers'),
       ('TV lovers'),
       ('Movie lovers'),
       ('Anime lovers'),
       ('Board game lovers'),
       ('Love programming');
