select concat('/home/grep/src/', board_id, '/', file_id, file_name, file_ext) as file_path
from used_goods_file 
where 
(
    select board_id
    from used_goods_board b
    order by views desc
    limit 1
) 
= board_id
order by file_id desc
;
