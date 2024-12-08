select 
    case 
        when group_concat(s.category) like '%Front End%' and group_concat(s.name) like '%Python%' then 'A'
        when group_concat(s.name) like '%C#%' then 'B'
        when group_concat(s.category) like '%Front End%' then 'C'
        end as grade, 
        id, email
from developers d
join skillcodes s
on d.skill_code & s.code = s.code
group by id, email
having grade is not null
order by grade, id
;
