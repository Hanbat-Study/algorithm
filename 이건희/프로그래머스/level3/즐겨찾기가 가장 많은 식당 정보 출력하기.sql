SELECT I.FOOD_TYPE, I.REST_ID, I.REST_NAME, I.FAVORITES
FROM REST_INFO AS I
JOIN (
    SELECT FOOD_TYPE, MAX(FAVORITES) AS FAVORITES
    FROM REST_INFO
    GROUP BY FOOD_TYPE
) AS T
ON I.FOOD_TYPE = T.FOOD_TYPE
AND I.FAVORITES = T.FAVORITES
ORDER BY I.FOOD_TYPE DESC;
