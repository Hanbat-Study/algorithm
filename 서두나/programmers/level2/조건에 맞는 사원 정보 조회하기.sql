select g.score, g.emp_no, emp_name, position, email
from
(select sum(score) as score, emp_no
from hr_grade
where year = 2022
group by emp_no) g
join hr_employees e
on g.emp_no = e.emp_no
order by g.score desc
limit 1
;
