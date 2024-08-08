-- 코드를 입력하세요
select month(start_date)  as month,car_id , count(history_id) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in (select car_id 
                 from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                 where start_date >='2022-08-01' and start_date <= '2022-11-30'
                 group by car_id
                having count(car_id)>=5)
                and  start_date >='2022-08-01' and start_date <= '2022-11-30'
group by month,car_id
having (records)>=0
order by month, car_id desc;