select a.id,
    if(pct <= 0.25, 'CRITICAL',
      if(pct <= 0.5, 'HIGH',
        if(pct <= 0.75, 'MEDIUM','LOW'))) as colony_name
from ecoli_data a
join (
    select id, percent_rank() over (order by size_of_colony desc) as pct
    from ecoli_data
) b
on a.id = b.id
order by a.id asc
;
