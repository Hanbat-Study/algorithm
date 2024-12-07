with recursive times as (
    select 0 as time
    union all
    select time+1
    from times
    where time<23
)
select  t.time as hour, count(a.animal_id) as count
from times t
left join animal_outs a
on t.time=hour(a.datetime)
group by hour
;
