


SELECT year(ym) as year,ROUND(AVG(pm_val1),2) as 'pm10', ROUND(AVG(pm_val2),2) as 'pm2.5'
FROM air_pollution
WHERE LOCATION2= '수원'
GROUP BY location2,year(ym)
ORDER BY YEAR



