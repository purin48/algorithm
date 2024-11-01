-- USED_GOODS_BOARD와 USED_GOODS_FILE 테이블에서
-- 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회
-- 첨부파일 경로는 FILE ID를 기준으로 내림차순 정렬

SELECT CONCAT("/home/grep/src/",BOARD_ID,"/",FILE_ID,FILE_NAME,FILE_EXT) AS "FILE_PATH"
FROM USED_GOODS_FILE
WHERE BOARD_ID = (
    SELECT BOARD_ID
    FROM USED_GOODS_BOARD
    ORDER BY VIEWS DESC
    LIMIT 1
)
ORDER BY FILE_ID DESC