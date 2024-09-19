-- 코드를 입력하세요

with cte as(
select writer_id,count(*) as cnt
from used_goods_board

group by writer_id)

select u.user_id,u.nickname,concat(u.city," ",u.street_address1," ",street_address2) as 전체주소,concat(substring(tlno,1,3),"-",substring(tlno,4,4),"-",substring(tlno,8,4)) as 전화번호 
from used_goods_user u join cte c on u.user_id = c.writer_id
where c.cnt>=3
order by u.user_id desc