CREATE TABLE Volunteer(
    firstName                   varchar2(30),
    lastName                    varchar2(30),
    street                      varchar2(30),
    city                        varchar2(30),
    state                       varchar2(30),
    zip                         varchar2(30),
    country                     varchar2(30),
    countryCode                 number(8),
    areaCode                    varchar2(30),
    telNumber                   varchar2(30),
    CONSTRAINT Volunteer_fname_lname_pk PRIMARY KEY (firstName, lastName));

    CREATE TABLE PotentialDonor(
    donorId                     number(8),
    firstName                   varchar2(30),
    lastName                    varchar2(30),
    street                      varchar2(30),
    city                        varchar2(30),
    state                       varchar2(30),
    zip                         varchar2(30),
    country                     varchar2(30),
    countryCode                 number(8),
    areaCode                    varchar2(30),
    telNumber                   varchar2(30),
    donorCircle                 varchar2(30),
    spouseName                  varchar2(30),
    amountDonatedLastYear       number(10,2),
    amountPledgedThisYear       number(10,2),
    amountPaidThisYear          number(10,2),
    CONSTRAINT PotentialDonor_dId_pk PRIMARY KEY (donorId),
    FOREIGN KEY (firstName, lastName) REFERENCES Volunteer(firstName, lastName));

    CREATE TABLE MatchingCorp(
        matchCorpName           varchar2(30),
        street                  varchar2(30),
        city                    varchar2(30),
        state                   varchar2(30),
        zip                     varchar2(30),
        country                 varchar2(30),
        countryCode             number(8),
        areaCode                varchar2(30),
        telNumber               varchar2(30),
        repName                 varchar2(30),
        repCountryCode          number(8),
        repAreaCode             varchar2(30),
        repTelNumber            varchar2(30),
        percentMatch            number(3),
        CONSTRAINT MatchingCorp_matCorName_pk PRIMARY KEY (matchCorpName));

    CREATE TABLE Event(
        eventName               varchar2(30),
        eventDate               date,
        eventTime               varchar2(30),
        eventLocation           varchar2(30),
        eventOrganizer          varchar2(30),
        eventTotalPledged       number(12,2),
        eventTotalPaid          number(12,2),
        CONSTRAINT Event_eName_pk PRIMARY KEY (eventName));

    CREATE TABLE ClassRep(
        graduationYear          date,
        firstName               varchar2(30),
        lastName                varchar2(30),
        street                  varchar2(30),
        city                    varchar2(30),
        state                   varchar2(30),
        zip                     varchar2(30),
        country                 varchar2(30),
        countryCode             number(8),
        areaCode                varchar2(30),
        telNumber               varchar2(30),
        CONSTRAINT ClassRep_gradYear_pk PRIMARY KEY (graduationYear));

    CREATE TABLE Pledge(
        pledgeNumber            number(8),
        pledgeAmount            number(10,2),
        pledgeDate              date,
        numPaymentsChosen       number(8),
        pledgeAmountPaid        number(10,2),
        numPaymentsMade         number(8),
        donorId                 number(8),
        eventName               varchar2(30),
        CONSTRAINT Pledge_pNum_pk PRIMARY KEY (pledgeNumber),
        FOREIGN KEY (donorId) REFERENCES PotentialDonor(donorId),
        FOREIGN KEY (eventName) REFERENCES Event(eventName));

    CREATE TABLE PledgePayment(
        pledgeNumber            number(8),
        datePaid                date,
        amountPaid              number(10,2),
        paymentMethod           varchar2(30),
        creditCardType          varchar2(30),
        creditCardNumber        varchar2(30),
        previousPaymentDate     date,
        matchingCorpName        varchar2(30),
        CONSTRAINT PledgePayment_pNum_dPaid_pk PRIMARY KEY (pledgeNumber, datePaid),
        FOREIGN KEY (pledgeNumber) REFERENCES Pledge(pledgeNumber),
        FOREIGN KEY (matchingCorpName) REFERENCES MatchingCorp(matchCorpName));

    CREATE TABLE Attends(
        donorId                 number(8),
        eventName               varchar2(30),
        CONSTRAINT Attends_dId_eName_pk PRIMARY KEY (donorId, eventName),
        FOREIGN KEY (donorId) REFERENCES PotentialDonor(donorId),
        FOREIGN KEY (eventName) REFERENCES Event(eventName));

    CREATE TABLE Matches(
        pledgeNumber            number(8),
        matchCorpName           varchar2(30),
        spouseName              number(8),
        CONSTRAINT Matches_pNum_matCorName_pk PRIMARY KEY (pledgeNumber, matchCorpName)
        FOREIGN KEY (matchCorpName) REFERENCES MatchingCorp(matchCorpName));

    CREATE TABLE DonorGradYear(
        donorId                 number(8),
        graduationYear          date,
        degree                  varchar2(30),
        CONSTRAINT DonorGradYear_dId_gradYear_pk PRIMARY KEY (donorId, graduationYear),
        FOREIGN KEY (donorId) REFERENCES PotentialDonor(donorId),
        FOREIGN KEY (graduationYear) REFERENCES ClassRep(graduationYear));

    CREATE TABLE DonorCategories(
        donorId                 number(8),
        donorCategory           varchar2(30),
        CONSTRAINT DonorCategories_dId_dCat_pk PRIMARY KEY (donorId, donorCategory),
        FOREIGN KEY (donorId) REFERENCES PotentialDonor(donorId));
    
    CREATE TABLE DonorChild(
        donorId                 number(8),
        childName               varchar2(30),
        childGradYear           date,
        CONSTRAINT DonorChild_dId_chName_pk PRIMARY KEY (donorId, childName),
        FOREIGN KEY (donorId) REFERENCES PotentialDonor(donorId));