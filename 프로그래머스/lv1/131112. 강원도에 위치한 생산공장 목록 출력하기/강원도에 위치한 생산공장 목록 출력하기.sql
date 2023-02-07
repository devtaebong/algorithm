-- 코드를 입력하세요
# 공장 ID, 공장 이름, 주소를 조회
# 공장 ID를 기준으로 오름차순
# 강원도에 위치
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
FROM FOOD_FACTORY 
WHERE ADDRESS LIKE '강원도%'
ORDER BY FACTORY_ID;