select 
    c.car_id, 
    c.car_type,
    convert(daily_fee * (1-(p.discount_rate * 0.01)) * 30,signed) as fee
from car_rental_company_car c
join car_rental_company_discount_plan p
on c.car_type = p.car_type
where
    c.car_type in ('세단', 'SUV')
    and c.car_id not in
    (
        select car_id
        from car_rental_company_rental_history
        where end_date >='2022-11-01' and start_date <= '2022-11-30'
    )
    and duration_type like '30%'
    and daily_fee * (1-(p.discount_rate * 0.01)) * 30 between 500000 and 2000000
order by fee desc, car_type asc, car_id desc
;
