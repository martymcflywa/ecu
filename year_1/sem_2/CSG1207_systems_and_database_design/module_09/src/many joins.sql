SELECT e.employee_id, e.first_name + ' ' + e.last_name AS 'full_name',
	   j.job_title,
	   m.first_name + ' ' + m.last_name AS 'manager_name',
	   d.department_name + ' (' + dm.first_name + ' ' + dm.last_name + ')' AS 'department',
	   l.street_address + ', ' + l.state_province + ', ' + l.postal_code + ',' + c.country_name AS 'dept_location'
	   	   
FROM employee AS e LEFT OUTER JOIN department AS d
  ON e.department_id = d.department_id
    INNER JOIN job AS j
    ON e.job_id = j.job_id
       LEFT OUTER JOIN location AS l
       ON d.location_id = l.location_id
         LEFT OUTER JOIN country AS c
         ON l.country_id = c.country_id
           LEFT OUTER JOIN employee AS m
           ON e.manager_id = m.employee_id
             LEFT OUTER JOIN employee AS dm
             ON d.manager_id = dm.employee_id