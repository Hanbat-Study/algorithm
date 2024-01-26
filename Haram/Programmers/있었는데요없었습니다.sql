select a.ANIMAL_ID, a.NAME from ANIMAL_INS as a
join ANIMAL_OUTS as b on a.ANIMAL_ID = b.ANIMAL_ID
where a.DATETIME > b.DATETIME
order by a.DATETIME