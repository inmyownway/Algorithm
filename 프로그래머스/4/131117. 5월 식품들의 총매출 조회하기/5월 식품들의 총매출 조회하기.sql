#1
SELECT a.product_id,a.product_name,sum(a.price * b.amount) as total_sales
from food_product a join ( select * from food_order where produce_date >= '2022-05-01' and produce_date <= '2022-05-31') b on a.product_id = b.product_id
group by a.product_id
order by total_sales desc, product_id asc