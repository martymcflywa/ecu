CREATE VIEW emp_names
AS	SELECT	employee_id AS 'e_id',
			first_name + ' ' + last_name AS 'full_name',
			last_name + ', ' + first_name AS 'surname_first',
			first_name + ' ' + UPPER(last_name) AS 'upper_surname',
			LEFT(first_name, 1) + '. ' + last_name AS 'first_initial',
			LEFT(first_name, 1) + '.' + LEFT(last_name, 1) + '.' AS 'initials',
			CASE gender WHEN 'M' THEN 'Mr. ' WHEN 'F' THEN 'Ms. ' ELSE '' END + last_name AS 'gender_name'
	FROM employee