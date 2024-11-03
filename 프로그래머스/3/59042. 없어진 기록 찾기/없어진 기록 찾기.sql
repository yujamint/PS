# 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회
SELECT ao.ANIMAL_ID, ao.NAME
FROM ANIMAL_OUTS ao
WHERE ao.ANIMAL_ID NOT IN (
    SELECT ANIMAL_ID
    FROM ANIMAL_INS
)
ORDER BY ao.ANIMAL_ID;

