-- #1
SELECT a.author_id,a.author_name,b.category,sum(s.sales*b.price) as total_sales
from book_sales s join book b on s.book_id = b.book_id
join author a on b.author_id = a.author_id
where sales_date like '2022-01%'
group by a.author_id,b.category
order by author_id asc, b.category desc