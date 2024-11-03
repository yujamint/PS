SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH FROM member_profile
WHERE date_of_birth like '%-03-%'
AND gender = 'W'
AND tlno is not null
ORDER BY member_id ASC;