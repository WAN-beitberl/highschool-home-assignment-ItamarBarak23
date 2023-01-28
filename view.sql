CREATE VIEW sima.StudentGrades AS
SELECT sima.highschool.id, sima.highschool.grade_avg
FROM sima.highschool
GROUP BY id;