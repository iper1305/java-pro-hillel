-- Отримання всіх записів Homework
SELECT * FROM Homework;

-- Отримання всіх записів Lesson, включаючи дані Homework
SELECT Lesson.*, Homework.*
FROM Lesson
JOIN Homework ON Lesson.homework_id = Homework.id;

-- Отримання всіх записів Lesson (включаючи дані Homework) відсортовані за часом оновлення
SELECT Lesson.*, Homework.*
FROM Lesson
JOIN Homework ON Lesson.homework_id = Homework.id
ORDER BY Lesson.updatedAt DESC;

-- Отримання всіх записів Schedule, включаючи дані Lesson
SELECT Schedule.*, Lesson.*, Homework.*
FROM Schedule
JOIN Lesson ON Schedule.id = Lesson.schedule_id
JOIN Homework ON Lesson.homework_id = Homework.id;

-- Отримання кількості Lesson для кожного Schedule
SELECT Schedule.id, COUNT(Lesson.id) AS lesson_count
FROM Schedule
LEFT JOIN Lesson ON Schedule.id = Lesson.schedule_id
GROUP BY Schedule.id;
