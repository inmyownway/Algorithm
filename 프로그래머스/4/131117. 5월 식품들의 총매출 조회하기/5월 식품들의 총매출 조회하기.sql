select o.product_id,p.product_name,sum(o.amount)*p.price as total_sales
from food_order o join food_product p on o.product_id = p.product_id
where o.PRODUCE_DATE like '2022-05%'
group by o.product_id
order by total_sales desc,o.product_id asc