-- 대여시작일 2022-9월에 속하는 것 중
-- 대여기간이 30일 이상이면 '장기' / 아니면 '단기'를 표시하는 RENT_TYPE 컬럼 생성 -> 대여기록 출력
-- HISTORY_ID 기준 DESC
-- Date 형식 맞추기

SELECT HISTORY_ID, CAR_ID,
       DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE,
       DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE,
       IF(DATEDIFF(END_DATE, START_DATE)+1 >= 30, '장기 대여', '단기 대여' ) AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE MONTH(START_DATE) = 9
ORDER BY HISTORY_ID DESC;