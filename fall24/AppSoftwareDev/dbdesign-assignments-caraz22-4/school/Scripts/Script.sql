
CREATE TABLE adoption_applications
(
	 application_ID		INT     	NOT NULL	IDENTITY		COMMENT 'Application ID Number'
	,pet_ID               	INT     	NOT NULL					COMMENT 'Pet ID Number'
	,adopter_ID           	INT     	NOT NULL					COMMENT 'Adopter ID Number'
	,staff_ID             	INT     	NOT NULL					COMMENT 'Staff ID Number'
	,date                 	DATETIME 	COMMENT 'Date of Application'
	-- ,status               	VARCHAR(15) 	DEFAULT 'Pending' CONSTRAINT chk_application_status CHECK (Status in ('Pending', 'Approved', 'Rejected'))	COMMENT 'Status of Application'

	,PRIMARY KEY (application_ID)								
)
COMMENT 'Adoption Application'
;

ALTER TABLE adoption_applications
	ADD CONSTRAINT	adoption_applications_pet_fk	COMMENT 'Constraint for adoption_applications table'
	FOREIGN KEY	(pet_ID)			COMMENT 'pet_ID foreign key in adoptions_application'
	REFERENCES      pets (pet_ID) 			COMMENT 'reference to pets table primary key'
	ON DELETE RESTRICT
	ON UPDATE RESTRICT;

ALTER TABLE adoption_applications
	ADD CONSTRAINT	adoption_applications_adopter_fk	COMMENT 'Constraint for adoption_applications table'
	FOREIGN KEY     (adopter_ID)				COMMENT 'adopter_ID foreign key in adoption_applications table'
	REFERENCES      adopters (adopter_ID)			COMMENT 'reference to adopters table primary key'
	ON DELETE RESTRICT
	ON UPDATE RESTRICT;

ALTER TABLE adoption_applications
	ADD CONSTRAINT	adoption_applications_staff_fk	COMMENT 'Constraint for adoption_applications table'
	FOREIGN KEY     (staff_ID)			COMMENT 'staff_ID foreign key in adoption_applications'
	REFERENCES      staff (staff_ID)		COMMENT 'reference to staff table primary key'
	ON DELETE RESTRICT
	ON UPDATE RESTRICT;