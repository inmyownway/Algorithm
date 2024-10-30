
with cte as(
select emp_no,avg(score) as score from hr_grade
group by emp_no)



select e.emp_no,e.emp_name,
case when h.score >= 96 then 'S' 
when h.score >= 90 and h.score < 96 then 'A'
when h.score >= 80 and h.score < 90 then 'B'
else 'C' end as grade,
case when h.score >= 96 then e.sal*0.2
when h.score >= 90 and h.score < 96 then e.sal*0.15
when h.score >= 80 and h.score < 90 then e.sal*0.1
else e.sal*0 end as bonus


from HR_EMPLOYEES e join cte h on e.emp_no = h.emp_no