# 종류 별로 가장 큰 물고기의 ID, 물고기 이름, 길이
SELECT fi.ID, fn.FISH_NAME, fi.LENGTH
FROM FISH_INFO fi
JOIN FISH_NAME_INFO fn
ON fi.fish_type = fn.fish_type
WHERE fi.fish_type in (
    SELECT fish_type
    FROM FISH_INFO
    GROUP BY fish_type
    HAVING LENGTH = MAX(LENGTH)
)
ORDER BY fi.id asc;