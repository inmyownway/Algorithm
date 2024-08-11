# 1
select a.rest_id,a.rest_name,a.food_type,a.favorites,a.address, round(avg(b.review_score),2) as score
from rest_info a join REST_REVIEW b on a.rest_id = b.rest_id
where a.address like '서울%'
group by a.rest_id
order by score desc,favorites desc