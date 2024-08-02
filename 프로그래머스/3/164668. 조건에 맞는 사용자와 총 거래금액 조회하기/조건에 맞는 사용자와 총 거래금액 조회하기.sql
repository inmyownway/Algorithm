-- 코드를 입력하세요
SELECT a.WRITER_ID as USER_ID,b.NICKNAME,sum(price) as TOTAL_SALES
from used_goods_board a,used_goods_user b
where a.writer_id = b.user_id and a.status = 'DONE'
group by a.writer_id
having sum(price) >= 700000
order by TOTAL_SALES