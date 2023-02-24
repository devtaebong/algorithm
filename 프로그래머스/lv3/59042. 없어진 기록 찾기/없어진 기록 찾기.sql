-- 코드를 입력하세요
# ANIMAL_OUTS 테이블의 ANIMAL_ID는 ANIMAL_INS의 ANIMAL_ID의 외래 키
# ANIMAL_INS(부모) ANIMAL_OUTS(자식)

# 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성

SELECT * from ANIMAL_INS;
SELECT * from ANIMAL_OUTS;

select 
    outs.ANIMAL_ID, outs.NAME
from 
    ANIMAL_OUTS outs

left join ANIMAL_INS ins
    on outs.ANIMAL_ID = ins.ANIMAL_ID
where ins.ANIMAL_ID is null;
    
# SELECT * from ANIMAL_OUTS where name = 'Daisy';
