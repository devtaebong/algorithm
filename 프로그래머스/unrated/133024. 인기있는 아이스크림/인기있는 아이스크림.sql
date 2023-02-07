-- 코드를 입력하세요

# 총주문량 기준으로 내림차순
# 총주문량이 같다면 출하번호 오름차순

SELECT FLAVOR from FIRST_HALF 
order by TOTAL_ORDER desc, SHIPMENT_ID asc;