with cte as (
select distinct cart_id,name from cart_products where name="Yogurt"
union all
select distinct cart_id,name from cart_products where name="Milk")

select cart_id from cte group by cart_id
having count(*)=2