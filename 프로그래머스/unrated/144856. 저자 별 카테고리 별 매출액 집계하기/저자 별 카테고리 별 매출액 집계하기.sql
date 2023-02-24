-- 코드를 입력하세요
# 저자별, 카테고리별 매출액 (TOTAL_SALES = 판매량 * 판매가)
# 저자 ID(AUTHOR_ID), 저자명(AUTHOR_NAME), 카테고리(CATEGORY), 매출액(SALES) 조회

SELECT 
    au.AUTHOR_ID, au.AUTHOR_NAME, b.CATEGORY, sum(bs.SALES * b.PRICE) as TOTAL_SALES
from BOOK b
join AUTHOR au
    on b.AUTHOR_ID = au.AUTHOR_ID
join BOOK_SALES bs
    on b.BOOK_ID = bs.BOOK_ID
where SALES_DATE like "2022-01%"
group by AUTHOR_ID, CATEGORY
order by AUTHOR_ID, CATEGORY desc;