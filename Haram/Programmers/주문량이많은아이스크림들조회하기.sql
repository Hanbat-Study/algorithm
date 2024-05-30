# FIRST_HALF: 아이스크림 가게의 상반기 주문 정보
# JULY: 7월의 아이스크림 주믄 정보
select b.FLAVOR from FIRST_HALF as a
join (
    select sum(b.TOTAL_ORDER) as TOTAL_ORDER, b.FLAVOR from JULY as b
    group by b.FLAVOR
) as b on a.FLAVOR = b.FLAVOR
order by a.TOTAL_ORDER + b.TOTAL_ORDER desc
limit 3