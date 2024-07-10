SELECT name, count(*) as 'COUNT'
FROM ANIMAL_INS
WHERE NAME is not null 
group by name
having count(*) >= 2
order by name;
