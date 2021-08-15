# https://leetcode.com/problems/department-top-three-salaries/
SELECT
    d.Name AS "Department",
    e.Name AS "Employee",
    e.Salary
FROM Department AS d
INNER JOIN Employee AS e
ON d.Id = e.DepartmentId

-- ranked salaries
INNER JOIN (
    SELECT
        DepartmentId,
        MIN(Salary) AS Min_Salary
    FROM
        (SELECT
             e2.DepartmentId,
             e2.Salary,
             DENSE_RANK() OVER(PARTITION BY e2.DepartmentId ORDER BY e2.Salary DESC) AS Salary_Num
         FROM Employee AS e2) t
    WHERE Salary_Num <= 3
    GROUP BY DepartmentId
) as sal
ON d.Id = sal.DepartmentId

WHERE e.Salary >= sal.Min_Salary;