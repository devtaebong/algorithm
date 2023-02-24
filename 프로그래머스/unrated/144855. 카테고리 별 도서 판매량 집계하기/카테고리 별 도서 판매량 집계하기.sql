-- 코드를 입력하세요
# 2022년 1월 카테고리별 도서 판매량 합산
# 카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력

SELECT CATEGORY, sum(b.SALES) as TOTAL_SALES
from BOOK a
join BOOK_SALES b on a.BOOK_ID = b.BOOK_ID
where b.SALES_DATE like "2022-01%"
group by a.CATEGORY
order by a.CATEGORY;

# select * from BOOK_SALES