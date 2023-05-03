SELECT donorCategory, COUNT(donorCategory) AS "Number of alum donators" FROM DonorCategories GROUP BY donorCategory;

SELECT firstName, lastName, state FROM Volunteer WHERE state = "NY";

SELECT PotentialDonor.firstName, PotentialDonor.lastName, Attends.eventName
FROM PotentialDonor
INNER JOIN Attends
ON PotentialDonor.donorId = Attends.donorId
WHERE Attends.eventName = "Holiday Dinner Dance";

SELECT MatchingCorp.matchCorpName, SUM(PledgePayment.amountPaid) AS "totalPaid"
FROM MatchingCorp
INNER JOIN PledgePayment
ON PledgePayment.matchingCorpName = MatchingCorp.matchCorpName
GROUP BY PledgePayment.matchingCorpName;

SELECT eventName, SUM(pledgeAmount) as "totalPledgeAmount" FROM Pledge WHERE eventName = "Holiday Dinner Dance" GROUP BY eventName;

SELECT eventName, SUM(pledgeAmount) as "totalPledgeAmount" FROM Pledge WHERE eventName != "" GROUP BY eventName;

SELECT PotentialDonor.donorId, PotentialDonor.firstName, PotentialDonor.lastName, SUM(Pledge.pledgeAmount) AS "totalPaid"
FROM PotentialDonor
INNER JOIN Pledge
ON PotentialDonor.donorId = Pledge.donorId
GROUP BY PotentialDonor.donorId;