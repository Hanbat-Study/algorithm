select id, 
if(size_of_colony>1000,'HIGH',if(size_of_colony>100,'MEDIUM','LOW')) as size 
from ecoli_data
order by id
;
