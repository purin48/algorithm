-- 서비스에서는 공간을 둘 이상 등록한 사람을 "헤비 유저"
-- 공간 정보를 아이디 순서로 조회
-- 헤비유저의 ID, NAME, HOST_ID 전부 출력
SELECT ID, NAME, HOST_ID
FROM PLACES
WHERE HOST_ID IN (
    SELECT HOST_ID
    FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(*) > 1
)
ORDER BY ID