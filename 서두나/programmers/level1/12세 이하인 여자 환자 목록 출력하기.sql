select pt_name, pt_no, gend_cd, age, ifnull(tlno,'NONE')
from patient
where age<=12 and gend_cd='w'
order by age desc, pt_name asc
;
