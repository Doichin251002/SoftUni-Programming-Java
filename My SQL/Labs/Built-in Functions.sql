USE book_library;

-- Problem 1
SELECT `title`
FROM books
WHERE substring(`title`, 1, 3) = 'The'
ORDER BY `id`;

-- Problem 2
SELECT replace(title, 'The', '***')
FROM books
WHERE substring(`title`, 1, 3) = 'The';

-- Problem 3
SELECT format(sum(`cost`), 2)
FROM books;

-- Problem 4
SELECT concat_ws(' ', `first_name`, `last_name`) AS `Full Name`,
timestampdiff(day, `born`, `died`) AS `Days Lived`
FROM authors;

-- Problem 5
SELECT `title`
FROM books
WHERE `title` LIKE 'Harry Potter%';

