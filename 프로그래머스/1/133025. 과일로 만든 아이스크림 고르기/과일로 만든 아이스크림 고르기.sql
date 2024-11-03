SELECT f.flavor FROM FIRST_HALF f
JOIN ICECREAM_INFO i
ON f.flavor = i.flavor
WHERE f.total_order > 3000 
AND i.ingredient_type = 'fruit_based'
ORDER BY f.total_order desc;