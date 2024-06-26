-- 대여 시작일 기준 2022-08 ~ 2022-10 총 대여횟수 5회 이상인 자동차
-- 월별 자동차ID 별 대여횟수(RECORDS)
-- 월 기준 ASC, 월이 같다면 자동차ID DESC 정렬
-- 대여 횟수 0이면 결과 제외

-- 1. 먼저 where 절에 car_id가 존재하는 지 조건 걸어줘야함
-- SELECT CAR_ID
-- FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
-- WHERE TO_CHAR(START_DATE, 'YYYY-MM') BETWEEN '2022-08' AND '2022-10'
-- GROUP BY CAR_ID
-- HAVING COUNT(CAR_ID) >= 5

-- SELECT TO_NUMBER(TO_CHAR(START_DATE, 'MM')) AS MONTH, CAR_ID, COUNT(CAR_ID) AS RECORDS
-- FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
-- WHERE CAR_ID IN (
--     SELECT CAR_ID
--     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
--     WHERE TO_CHAR(START_DATE, 'YYYY-MM') BETWEEN '2022-08' AND '2022-10'
--     GROUP BY CAR_ID
--     HAVING COUNT(CAR_ID) >= 5
-- )
-- AND
--     TO_CHAR(START_DATE, 'YYYY-MM') BETWEEN '2022-08' AND '2022-10'   
-- GROUP BY START_DATE, CAR_ID
-- ORDER BY MONTH ASC, RECORDS DESC;

SELECT TO_NUMBER(TO_CHAR(START_DATE, 'MM')) AS MONTH, CAR_ID, COUNT(CAR_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE TO_CHAR(START_DATE, 'YYYY-MM') BETWEEN '2022-08' AND '2022-10'
    GROUP BY CAR_ID
    HAVING COUNT(CAR_ID) >= 5
)
AND
    TO_CHAR(START_DATE, 'YYYY-MM') BETWEEN '2022-08' AND '2022-10' 
GROUP BY TO_NUMBER(TO_CHAR(START_DATE, 'MM')), CAR_ID
ORDER BY MONTH ASC, CAR_ID DESC;