# 1
select count(*) as fish_count ,max(length) as max_length,fish_type  
from (select fish_type, case when length <= 10 then 10 when length is null then 10 else length end as length from fish_info) as a 
group by fish_type 
having avg(length) >= 33
order by fish_type