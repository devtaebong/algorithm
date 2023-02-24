-- 코드를 입력하세요
# 동물의 생물 종, 이름, 성별 및 중성화 여부 조회
# 아이디 순으로 오름차순
# 이름이 없는 동물의 이름은 No name
# select * from ANIMAL_INS;


select 
    ANIMAL_TYPE, IFNULL(NAME, "No name") as NAME, SEX_UPON_INTAKE
from 
    ANIMAL_INS
order by ANIMAL_ID;