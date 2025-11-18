USE shopDB;

SELECT Customers.FName AS FirstName_Customers, Employees.FName AS FirstName_Employees From Orders 
INNER JOIN Customers
ON Orders.OrderID = Customers.CustomerNo
INNER JOIN Employees
ON Orders.OrderID = Employees.EmployeeID
INNER JOIN OrderDetails
ON Orders.OrderID = OrderDetails.OrderID
WHERE OrderDetails.TotalPrice > 1000;

