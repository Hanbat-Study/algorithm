select f.id, i.fish_name, t.length
from fish_info f
join
(
select fish_type, max(length) as length
from fish_info f
group by fish_type
) as t
on f.fish_type = t.fish_type and f.length = t.length
join fish_name_info i
on f.fish_type = i.fish_type
order by f.id asc
;
