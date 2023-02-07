-- 코드를 입력하세요

# 생일 3월, 성별: 여성
# 전화번호가 null 이면 출력하지 않음
# 회원 id, 이름, 성별, 생년월일 조회
# 회원id 오름차순
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') 
as DATE_OF_BIRTH
from MEMBER_PROFILE
where GENDER = 'W' and MONTH(DATE_OF_BIRTH) = '03' and TLNO is NOT NULL
order by MEMBER_ID;