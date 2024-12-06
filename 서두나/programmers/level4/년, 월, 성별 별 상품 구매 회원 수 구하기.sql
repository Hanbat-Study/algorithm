select year(sales_date) as year, month(sales_date) as month, gender, count(distinct o.user_id) as users
from online_sale o
join user_info u
on o.user_id = u.user_id
group by year, month, gender
having gender is not null
order by year, month, gender
;
