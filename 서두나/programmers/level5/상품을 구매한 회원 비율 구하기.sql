select year(sale.sales_date) as year, 
month(sale.sales_date) as month, 
count(distinct(sale.user_id)) as puchased_users, 
round(count(distinct(sale.user_id))/(select count(*) from user_info where year(joined)=2021),1) as puchased_ratio  
from (
  select * 
  from user_info 
  where year(joined)=2021
) user 
join online_sale sale
on user.user_id=sale.user_id
group by date_format(sale.sales_date,'%Y-%m')
order by year asc, month asc
