select b.author_id, author_name, category, sum(sales * price) as total_sales
from 
(
select book_id, sum(sales) as sales
from book_sales
where year(sales_date) = 2022 and month(sales_date)=1
group by book_id
) t
join book b
on t.book_id = b.book_id
join author a
on b.author_id = a.author_id
group by b.author_id, category
order by b.author_id asc, category desc
;
