-- 코드를 입력하세요
SELECT a.apnt_no , p.pt_name , p.pt_no, d.mcdp_cd, d.dr_name, a.apnt_ymd
from APPOINTMENT a 
join doctor d on a.mddr_id = d.dr_id
join patient p on a.pt_no = p.pt_no
where a.MCDP_CD = 'CS' and a.apnt_ymd like '2022-04-13%' and a.apnt_cncl_yn ='N'
order by apnt_ymd;
