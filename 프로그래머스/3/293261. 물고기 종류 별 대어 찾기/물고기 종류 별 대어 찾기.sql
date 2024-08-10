SELECT 
    a.id AS ID,
    b.fish_name AS FISH_NAME,
    a.length AS LENGTH
FROM 
    fish_info a
JOIN 
    fish_name_info b ON a.fish_type = b.fish_type
WHERE 
    a.length = (
        SELECT 
            MAX(length)
        FROM 
            fish_info
        WHERE 
            fish_type = a.fish_type
    )
ORDER BY 
    a.id ASC;
