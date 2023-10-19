-- ADDRESS : 경기%
-- FREEZER_YN가 NULL = 'N'으로 출력
-- 결과는 창고 ID를 기준으로 오름차순 정렬
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS,
       IFNULL(FREEZER_YN, 'N') AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기%'
ORDER BY WAREHOUSE_ID;