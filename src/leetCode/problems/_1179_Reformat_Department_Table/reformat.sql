SELECT id, 
SUM(CASE
	WHEN month = 'Jan'
	THEN revenue
	ELSE NULL
end) as Jan_Revenue,
SUM(CASE
	WHEN month = 'Feb'
	THEN revenue
	ELSE NULL
end) as Feb_Revenue,
SUM(CASE
	WHEN month = 'Mar'
	THEN revenue
	ELSE NULL
end) as Mar_Revenue,
SUM(CASE
	WHEN month = 'Apr'
	THEN revenue
	ELSE NULL
end) as Apr_Revenue,
SUM(CASE
	WHEN month = 'May'
	THEN revenue
	ELSE NULL
end) as May_Revenue,
SUM(CASE
	WHEN month = 'Jun'
	THEN revenue
	ELSE NULL
end) as Jun_Revenue,
SUM(CASE
	WHEN month = 'Jul'
	THEN revenue
	ELSE NULL
end) as Jul_Revenue,
SUM(CASE
	WHEN month = 'Aug'
	THEN revenue
	ELSE NULL
end) as Aug_Revenue,
SUM(CASE
	WHEN month = 'Sep'
	THEN revenue
	ELSE NULL
end) as Sep_Revenue,
SUM(CASE
	WHEN month = 'Oct'
	THEN revenue
	ELSE NULL
end) as Oct_Revenue,
SUM(CASE
	WHEN month = 'Nov'
	THEN revenue
	ELSE NULL
end) as Nov_Revenue,
SUM(CASE
	WHEN month = 'Dec'
	THEN revenue
	ELSE NULL
end) as Dec_Revenue
from Department as d
group by id
order by id