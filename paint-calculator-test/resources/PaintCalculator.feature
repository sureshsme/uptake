Feature: Testing Paint Calculator Application 

Scenario Outline: Expected number of rooms are displayed in Dimensions page 
	Given I am in Home page 
	When I submit number of rooms as <number> 
	Then I should see <number> rows in Dimensions page 
	
	Examples: 
		|number |
		|2      |
		|5      |
		
Scenario: Expected number of rooms are displayed in Results page for single room 
	Given I am in Home page 
	When I submit number of rooms as 1 
	And I submit room dimensions as: 
		|length |width |height |
		|10     |10    |10     |
	Then I should see 1 rows in Results page 
	
Scenario: Expected number of rooms are displayed in Results page for multiple rooms
	Given I am in Home page 
	When I submit number of rooms as 4 
	And I submit room dimensions as: 
		|length |width |height |
		|10     |10    |10     |
		|10     |10    |10     |
		|10     |10    |10     |
		|10     |10    |10     |
	Then I should see 4 rows in Results page 
	
Scenario: The surface area to paint is ((Length * 2) + (Width * 2)) * Height for single room 
	Given I am in Home page 
	When I submit number of rooms as 1 
	And I submit room dimensions as: 
		|length |width |height |
		|10     |10    |10     |
	Then I should see Surface Area calculated in Results page for each room as: 
		|400    |
		
Scenario: The surface area to paint is ((Length * 2) + (Width * 2)) * Height for multiple rooms
	Given I am in Home page 
	When I submit number of rooms as 3 
	And I submit room dimensions as: 
		|length |width |height |
		|10     |10    |10     |
		|12     |14    |10     |
		|8      |5     |8      |
	Then I should see Surface Area calculated in Results page for each room as: 
		|400    |
		|520    |
		|208    |
		
Scenario: Gallons Required per room is Surface Area / 400 rounded up for single room
	Given I am in Home page 
	When I submit number of rooms as 1 
	And I submit room dimensions as: 
		|length |width |height |
		|10     |10    |11     |
	Then I should see Gallons Required calculated in Results page for each room as: 
		|2      |
		
Scenario: Gallons Required per room is Surface Area / 400 rounded up for multiple rooms
	Given I am in Home page 
	When I submit number of rooms as 4 
	And I submit room dimensions as: 
		|length |width |height |
		|10     |10    |10     |
		|10     |10    |11     |
		|20     |28    |12     |
		|3      |1     |2      |
	Then I should see Gallons Required calculated in Results page for each room as: 
		|1      |
		|2      |
		|3      |
		|1      |
		
Scenario: Navigation between pages works 
	Given I am in Home page 
	When I submit number of rooms as 1 
	Then I should be in Dimensions page 
	And I submit room dimensions as: 
		|length |width |height |
		|10     |10    |11     |
	Then I should be in Results page 
	And I click on Home button 
	Then I should be in Home page 
	
Scenario Outline: Invalid room count in Home page 
	Given I am in Home page 
	When I submit number of rooms as <number> 
	Then I should stay in Home page and get an error message 
	Examples: 
		|number |
		|       |
		|0      |
		|-1     |
		|10.5   |
		
Scenario Outline: Invalid dimension in Dimensions page 
	Given I am in Home page 
	When I submit number of rooms as 1 
	And I submit room dimensions as: 
		|length |width |height |
		|<l>    |<w>   |<h>    | 
	Then I should stay in Dimensions page and get an error message 
	Examples: 
		|l      |w     |h      |
		|       |2     |3      |
		|1      |0     |3      |		
		|1      |2     |-1     |
		|1.1    |2     |3      |
		
		
Scenario: End to End validation 
	Given I am in Home page 
	When I submit number of rooms as 1 
	And I submit room dimensions as: 
		|length |width |height |
		|1      |10    |10     |
	Then I should see Surface Area calculated in Results page for each room as: 
		|220    |
	And I should see Gallons Required calculated in Results page for each room as: 
		|1      |
	And I should see Total Gallons Required in Results page as 1 
	
Scenario: End to End validation 
	Given I am in Home page 
	When I submit number of rooms as 4 
	And I submit room dimensions as: 
		|length |width |height |
		|10     |10    |10     |
		|10     |10    |11     |
		|20     |28    |12     |
		|3      |1     |2      |
	Then I should see Surface Area calculated in Results page for each room as: 
		|400    |
		|440    |
		|1152   |
		|16     |
	And I should see Gallons Required calculated in Results page for each room as: 
		|1      |
		|2      |
		|3      |
		|1      |
	And I should see Total Gallons Required in Results page as 7 
	
