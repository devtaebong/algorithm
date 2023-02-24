-- 코드를 입력하세요
# 2022년 5월에 예약한 환자 수를 진료과코드 별로 조회
# select * from APPOINTMENT;

select 
    MCDP_CD as '진료과 코드', count(*) as '5월예약건수'
from 
    APPOINTMENT
where APNT_YMD like('2022-05%')
group by MCDP_CD
order by count(*), MCDP_CD;
