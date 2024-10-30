select i.item_id, i.item_name, i.rarity
from item_info i 
join item_tree t
on i.item_id=t.item_id
join item_info p
on t.parent_item_id=p.item_id
where p.rarity='RARE'
order by i.item_id desc
;
