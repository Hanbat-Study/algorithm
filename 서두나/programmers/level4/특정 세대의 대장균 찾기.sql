with recursive cte(id, parent_id, cnt)
as(
    # Non-Recursive 문장( 첫번째 루프에서만 실행됨 )
    select id, parent_id, 1 as cnt
    from ecoli_data
    where parent_id is null
    union all
    # Recursive 문장(읽어 올 때마다 행의 위치가 기억되어 다음번 읽어 올 때 다음 행으로 이동함)
    select eco.id, eco.parent_id, cte.cnt+1 as cnt
    from ecoli_data eco
    join cte
    on eco.parent_id=cte.id
)
select id
from cte
where cnt=3
;
