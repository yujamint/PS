SELECT ANIMAL_TYPE, COUNT(*) as count
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
HAVING ANIMAL_TYPE = 'Cat'
    OR ANIMAL_TYPE = 'Dog'
ORDER BY ANIMAL_TYPE;