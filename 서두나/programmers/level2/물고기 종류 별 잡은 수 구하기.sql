select fish_count as fish_count, fish_name
from
(select count(*) as fish_count, fish_type
from fish_info
group by fish_type
) a
left join fish_name_info b
on a.fish_type= b.fish_type
order by fish_count desc
;
