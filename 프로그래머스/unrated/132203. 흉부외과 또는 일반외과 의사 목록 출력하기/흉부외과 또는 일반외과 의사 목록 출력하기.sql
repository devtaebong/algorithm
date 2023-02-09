-- 코드를 입력하세요
# 진료과가 흉부외과 또는 일반외과
# 의사의 이름, id, 고용일자 조회

SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') as HIRE_YMD from DOCTOR
where MCDP_CD = 'CS' or MCDP_CD = 'GS'
order by HIRE_YMD desc, DR_NAME;