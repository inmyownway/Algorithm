
select c.id from ecoli_data a
join ecoli_data b on a.id = b.parent_id 
join ecoli_data c on b.id = c.parent_id
where a.parent_id is null
order by c.id;
