select month(start_date) as month, t1.car_id, count(*) as records
from
(
    select car_id
    from car_rental_company_rental_history
    where year(start_date)=2022 and month(start_date) between 8 and 10
    group by car_id
    having count(*)>=5
) t1
join car_rental_company_rental_history t2
on t1.car_id = t2.car_id
where year(start_date)=2022 and month(start_date) between 8 and 10
group by month, car_id
order by month asc, car_id desc
;
