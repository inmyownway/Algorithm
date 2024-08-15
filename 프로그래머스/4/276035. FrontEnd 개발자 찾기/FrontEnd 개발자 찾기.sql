-- #1

select distinct a.id,a.email,a.first_name,a.last_name
from DEVELOPERS a join SKILLCODES b on b.code =  a.skill_code & b.code
where b.category = 'Front End'
order by a.id;

