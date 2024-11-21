with recursive cte(id, parent_id, gener)
as (
    select id, parent_id, 1 as gener
    from ecoli_data
    where parent_id is null
    union all
    select ec.id, ec.parent_id, cte.gener+1 as gener
    from ecoli_data ec
    join cte
    on ec.parent_id = cte.id
)
select count(a.gener) as count, a.gener as generation
from cte a
left join cte b
on a.id = b.parent_id
where b.parent_id is null
group by generation
order by generation
;
