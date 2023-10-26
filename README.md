# TACC-Green1
# SoftServe Test Automation Crash Course 2023 - Team: green1
### Class: Person
#### Fields:

- name: Private field to store the name of the person.
- birthYear: Private field to store the birth year of the person.

#### Constructors:

- Person(): Default constructor with no parameters.
- Person(String name, int birthYear): Constructor with parameters to initialize the name and birthYear fields.

#### Methods:

- getName(): Public method to retrieve the name of the person.
- setName(String name): Public method to set the name of the person.
- getBirthYear(): Public method to retrieve the birth year of the person.
- setBirthYear(int birthYear): Public method to set the birth year of the person.
- calculateAge(): Public method to calculate the age of the person based on the current year and the birth year.
- changeName(String newName): Public method to change the name of the person.
- input(): Public method to input information about the person from the console (name and birth year).
- output(): Public method to output information about the person to the console (name, birth year, and age).

#### Usage:

- The class can be instantiated to create Person objects, and their information can be set using the input() method or directly by calling the setter methods.
- The calculateAge() method can be used to get the person's age based on the current year and the stored birth year.
- The output() method can be used to display the person's information, including their name, birth year, and age.
- This class provides a convenient way to create and manage person objects, input their information, calculate their age, and display their details. It follows encapsulation principles by keeping the fields private and providing public methods to access and modify the data.
