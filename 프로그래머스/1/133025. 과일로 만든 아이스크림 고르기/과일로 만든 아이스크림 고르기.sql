-- 코드를 입력하세요
SELECT f.FLAVOR FROM FIRST_HALF f LEFT JOIN ICECREAM_INFO i ON f.FLAVOR = i.FLAVOR WHERE TOTAL_ORDER>3000 AND i.INGREDIENT_TYPE = 'fruit_based' ORDER BY TOTAL_ORDER DESC;