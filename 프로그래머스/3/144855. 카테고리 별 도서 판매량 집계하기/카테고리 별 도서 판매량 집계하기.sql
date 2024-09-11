-- 코드를 입력하세요
SELECT b.category,sum(s.sales) as total_sales
from booK_sales s join book b on s.book_id = b.booK_id
where s.sales_date like '2022-01%'
group by b.category
order by b.category
