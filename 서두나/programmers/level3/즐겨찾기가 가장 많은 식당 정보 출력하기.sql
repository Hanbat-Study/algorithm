SELECT r.food_type, rest_id, rest_name, r.favorites
from rest_info r
join (
    select food_type, max(favorites) as favorites
    from rest_info
    group by food_type
    ) as t
on r.food_type=t.food_type
where r.favorites=t.favorites
order by r.food_type desc
;
