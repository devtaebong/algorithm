-- 코드를 입력하세요
# 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회
# 보호 시작일이 빠른 순으로 조회

SELECT * from ANIMAL_INS; # 보호 시작일
SELECT * from ANIMAL_OUTS; # 입양일

select
    ins.ANIMAL_ID, ins.NAME
from 
    ANIMAL_INS ins
join ANIMAL_OUTS outs
    on ins.ANIMAL_ID = outs.ANIMAL_ID
where outs.DATETIME - ins.DATETIME < 0
order by ins.DATETIME;

# SELECT * from ANIMAL_INS ins
# join ANIMAL_OUTS outs
#     on ins.ANIMAL_ID = outs.ANIMAL_ID; # 입양일
