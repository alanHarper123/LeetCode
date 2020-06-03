SELECT 
	case
	when mod(i,2)=0 then id-1
	when id<totalCount then id+1
	else id 
	end as id,
	student
	FROM seat,
	(SELECT COUNT(*) AS totalCount FROM seat) as seat_count
ORDER BY id;