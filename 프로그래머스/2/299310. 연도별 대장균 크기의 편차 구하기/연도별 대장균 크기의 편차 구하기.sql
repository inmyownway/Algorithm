with cte as(

    select max(size_of_colony) as maxCnt,date_format(DIFFERENTIATION_DATE,'%Y') as y
    from ecoli_data
    group by y
)
select YEAR(e.DIFFERENTIATION_DATE) as YEAR,c.maxCnt - e.size_of_colony as YEAR_DEV,e.id as ID from 
ecoli_data e join cte c on date_format(e.DIFFERENTIATION_DATE,'%Y') = c.y
order by YEAR asc, YEAR_DEV 