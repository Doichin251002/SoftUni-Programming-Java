USE book_library;

# Query 1. Find Book Titles
SELECT `title`
FROM books
WHERE substring(`title`, 1, 3) = 'The'
ORDER BY `id`;

# Query 2. Replace Titles
SELECT replace(title, 'The', '***')
FROM books
WHERE substring(`title`, 1, 3) = 'The';

# Query 3. Sum Cost of All Books
SELECT format(sum(`cost`), 2)
FROM books;

# Query 4. Days Lived
SELECT concat_ws(' ', `first_name`, `last_name`) AS `Full Name`,
timestampdiff(day, `born`, `died`) AS `Days Lived`
FROM authors;

# Query 5. Harry Potter Books
SELECT `title`
FROM books
WHERE `title` LIKE 'Harry Potter%';

