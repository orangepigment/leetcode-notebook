# https://leetcode.com/problems/trips-and-users/
SELECT
    t.Request_at AS Day,
  ROUND(
    SUM(
      CASE
        WHEN t.Status = 'completed' THEN 0
        ELSE 1
      END
    ) / COUNT(1),
    2
  ) AS "Cancellation Rate"
FROM Trips AS t

INNER JOIN Users AS Cl
ON t.Client_Id = Cl.Users_Id
    AND Cl.Banned = 'No'

INNER JOIN Users AS Dr
ON t.Driver_Id = Dr.Users_Id
    AND Dr.Banned = 'No'

WHERE t.Request_at BETWEEN '2013-10-01' AND '2013-10-03'

GROUP BY t.Request_at;

