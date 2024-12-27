select product_code, sum(sales_amount)*price as sales 
from product p 
left join offline_sale s 
on p.product_id = s.product_id 
group by product_code 
order by sales desc, product_code asc
