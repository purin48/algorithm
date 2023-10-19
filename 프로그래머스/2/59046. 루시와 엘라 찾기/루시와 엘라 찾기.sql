-- 이름이 Lucy, Ella, Pickle, Rogan, Sabrina, Mitty인 동물의 정보 조회
-- ANIMAL_ID 기준으로 조회
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME IN ('Lucy','Ella','Pickle','Rogan','Sabrina','Mitty')
ORDER BY ANIMAL_ID;