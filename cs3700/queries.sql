SELECT donorCategory, COUNT(donorCategory) AS "Number of alum donators" FROM DonorCategories WHERE donorCategory = "alum";
SELECT donorCategory, COUNT(donorCategory) AS "Number of parent donators" FROM DonorCategories WHERE donorCategory = "parent";

SELECT firstName, lastName, state FROM Volunteer WHERE state = "NY";

SELECT PotentialDonor.firstName, PotentialDonor.lastName, Attends.eventName
FROM PotentialDonor
INNER JOIN Attends
ON PotentialDonor.donorId=Attends.donorId
WHERE Attends.eventName = "Holiday Dinner Dance";

