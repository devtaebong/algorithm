-- 코드를 입력하세요
# 가장 오래 있었던 동물 3마리 limit
# 이름과 보호 시작일을 조회

SELECT 
    ins.name, ins.DATETIME as DATETIME
from 
    ANIMAL_INS ins
    
left join ANIMAL_OUTS outs
    on ins.ANIMAL_ID = outs.ANIMAL_ID
where 
    ins.DATETIME in(select ins.DATETIME from ANIMAL_INS ins order by ins.DATETIME)
and
    outs.ANIMAL_ID is null
order by DATETIME
limit 3;

