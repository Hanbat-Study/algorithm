select year(e1.differentiation_date)as year, 
e2.max_size-e1.size_of_colony as year_dev, 
id
from ecoli_data e1 
join
(
    select year(differentiation_date)as year, 
    max(size_of_colony) as max_size
    from ecoli_data
    group by year(differentiation_date)
) as e2
on year(e1.differentiation_date)=e2.year
order by year asc, year_dev asc
;
