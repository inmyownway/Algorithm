-- 코드를 입력하세요
with cte as(
select board_id
from used_goods_board
order by views desc
limit 1)

select concat("/home/grep/src/",c.board_id,"/",u.file_id,u.file_name,u.file_ext) as FILE_PATH
from cte c join used_goods_file u on c.board_id = u.board_id
order by u.file_id desc
