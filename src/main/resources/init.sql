-- initsql.sql

-- Створення таблиці Homework
CREATE TABLE Homework (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description TEXT
);

-- Створення таблиці Lesson
CREATE TABLE Lesson (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    updatedAt TIMESTAMP,
    homework_id INTEGER REFERENCES Homework(id) UNIQUE
);

-- Створення таблиці Schedule
CREATE TABLE Schedule (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    updatedAt TIMESTAMP,
    lesson_id INTEGER REFERENCES Lesson(id)
);
