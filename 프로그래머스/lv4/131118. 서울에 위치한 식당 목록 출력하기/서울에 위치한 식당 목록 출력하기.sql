-- 코드를 입력하세요
# 1. 서울에 위치한 식당 id, 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수를 조회
# 2. 리뷰 평균점수는 소수점 세 번째 자리에서 반올림 
# 3. 평균점수를 기준으로 내림차순 정렬해주시고, 평균점수가 같다면 즐겨찾기수를 기준으로 내림차순 정렬

select 
    i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES, i.ADDRESS, round(avg(r.REVIEW_SCORE) ,2) as SCORE
from
    REST_INFO i
join REST_REVIEW r on r.REST_ID = i.REST_ID
where 
    ADDRESS like "서울%"
group by i.REST_ID
order by
    SCORE desc, i.FAVORITES desc