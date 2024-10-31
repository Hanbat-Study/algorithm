select id, email, first_name, last_name 
from developers d
where skill_code & (
    select sum(code) 
    from skillcodes
    where name = 'Python'
    or name = 'C#'
)
order by id asc
;
