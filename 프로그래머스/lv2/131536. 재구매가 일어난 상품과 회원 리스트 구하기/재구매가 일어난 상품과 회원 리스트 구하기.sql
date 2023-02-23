-- 코드를 입력하세요
# 1. 동일한 회원이 동인한 상품을 재구매한 데이터를 구한다
# 2. 재구매한 회원의ID, 재구매한 상품 ID를 조회한다.
# 3. 회원 아이디를 기준으로 오름차순, 상품 아이디 내림차순
SELECT 
    USER_ID, PRODUCT_ID 
from 
    ONLINE_SALE
group by 
    USER_ID, PRODUCT_ID
having 
    count(*)  >= 2
order by 
    USER_ID, PRODUCT_ID desc;
