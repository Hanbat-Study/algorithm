
SELECT distinct car_id,
case
    when car_id in (
        select car_id
        from car_rental_company_rental_history
        where start_date <= '2022-10-16' and '2022-10-16' <= end_date
    )
    then '대여중'
    else '대여 가능'
    end as availability
from car_rental_company_rental_history



order by car_id desc;
