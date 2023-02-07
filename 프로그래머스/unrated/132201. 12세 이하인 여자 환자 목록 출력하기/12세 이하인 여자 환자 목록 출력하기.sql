-- 코드를 입력하세요

# 12세이하, 여자환자
# 환자이름, 환자번호, 성별코드, 나이, 전화번호
# 전화번호가 없으면 none
# 나이를 기준으로 내림차순 정렬
# 나이가 같다면 환자이름으로 오름차순 정렬

SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE') as TLNO from PATIENT
where age <= 12 and GEND_CD = 'W'
order by AGE desc, PT_NAME;