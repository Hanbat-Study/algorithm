-- 코드를 입력하세요
SELECT mcdp_cd, count(*) as '5월예약건수' from appointment 
where date_format(apnt_ymd,'%m') = 5 
group by mcdp_cd
order by count(*) asc, mcdp_cd asc
;
