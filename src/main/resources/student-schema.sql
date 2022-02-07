DROP TABLE IF EXISTS student CASCADE;
create table student (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    dob DATETIME NOT NULL,
    scholarship_status boolean NOT NULL,
    gpa float,
    age SMALLINT,
    primary key (id)
);