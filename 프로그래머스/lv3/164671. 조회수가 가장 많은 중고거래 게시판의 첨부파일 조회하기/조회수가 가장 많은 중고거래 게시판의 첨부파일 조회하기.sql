-- 코드를 입력하세요
SELECT CONCAT("/home/grep/src/", ugf.BOARD_ID, "/", ugf.FILE_ID, ugf.FILE_NAME, ugf.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_FILE as ugf
WHERE ugf.BOARD_ID = (SELECT ugb.BOARD_ID
                      FROM USED_GOODS_BOARD as ugb
                      WHERE ugb.VIEWS = (SELECT MAX(b.VIEWS)
                                         FROM USED_GOODS_BOARD as b))
ORDER BY ugf.FILE_ID DESC;
