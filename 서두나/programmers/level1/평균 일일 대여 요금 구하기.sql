select round(sum(daily_fee)/count(*)) as average_fee
from car_rental_company_car
where car_type='suv'
;
