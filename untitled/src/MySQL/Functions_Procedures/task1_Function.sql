USE carsshop;

DELIMITER |

CREATE FUNCTION MinAge(mark varchar(30))
RETURNS INT
READS SQL DATA
BEGIN
RETURN (SELECT MIN(clients.age) FROM clients
INNER JOIN orders
ON clients.id = orders.id
INNER JOIN cars 
ON orders.id = cars.id
INNER JOIN marks
ON cars.id = marks.id
WHERE marks.mark = mark);
END
|

SELECT mark, minAge(mark) FROM marks;|