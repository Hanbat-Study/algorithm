select count(*) as count
from ecoli_data
where (genotype & 5) and (genotype & 2 !=2)
;
