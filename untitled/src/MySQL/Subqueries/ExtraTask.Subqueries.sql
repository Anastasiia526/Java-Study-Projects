USE ShopDB;

SELECT (SELECT FName FROM Customers
WHERE CustomerNo = (SELECT CustomerNo FROM Orders
WHERE Orders.OrderID = OrderDetails.OrderID)) AS FName_Customers,
(SELECT LName FROM Customers
WHERE CustomerNo = (SELECT CustomerNo FROM Orders
WHERE Orders.OrderID = OrderDetails.OrderID)) AS LName_Customers,
(SELECT FName FROM Employees
WHERE EmployeeID = (SELECT EmployeeID FROM Orders
WHERE Orders.OrderID = OrderDetails.OrderID)) AS FName_Employees,
(SELECT LName FROM Employees
WHERE EmployeeID = (SELECT EmployeeID FROM Orders
WHERE Orders.OrderID = OrderDetails.OrderID)) AS LName_Employees
 FROM OrderDetails
 WHERE TotalPrice > 1000;
