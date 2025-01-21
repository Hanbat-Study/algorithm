select case 
    when month(differentiation_date) >=10 then '4Q'
    when month(differentiation_date) >=7 then '3Q'
    when month(differentiation_date) >=4 then '2Q'
    else '1Q'
    end as quarter,
    count(*) as ecoli_count
from ecoli_data
group by quarter
order by quarter asc
;
