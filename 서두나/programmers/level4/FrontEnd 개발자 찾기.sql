select distinct(id), email, first_name, last_name
from developers d
join
(
    select code
    from skillcodes
    where category = 'Front End'
) f
on d.skill_code & f.code = f.code
order by id
;
