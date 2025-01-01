select outs.animal_id, outs.animal_type, outs.name 
from 
(
  select animal_id 
  from animal_ins 
  where sex_upon_intake 
  like 'Intact%'
) intake
join animal_outs outs 
on intake.animal_id=outs.animal_id
where outs.sex_upon_outcome not like 'Intact%'
order by outs.animal_id asc
