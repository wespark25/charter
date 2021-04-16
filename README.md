![Screen Shot 2021-04-16 at 11 32 41 AM](https://user-images.githubusercontent.com/43556685/115061019-31af4400-9eae-11eb-9edf-4dbb8f2f7369.png)

How to Use:

Set up  a local database with the information provided in /charter/src/main/resources/application.properties.
 
Then all you need to do is run the application and open localhost:8080 on a web browser.



How it works:

When the application starts DbInitializer.java, which implements Command Line Runner, checks to see if there are any transaction entities currently exist in the local database. If no entities exist DbInitializer.java will parse a csv file in the same directory. The csv file contains two values per row: a name and an integer. For each row in the csv file, a transaction entity is created. If no corresponding customer entity exists for the name, a customer entity is created. Customer entities have a one to many relationship with transaction entities.

The RestController provides only one method because there are no user inputs and only the index page is used.

Check out my Library project for an example of a more robust use of SpringBoot architecture and CRUD: https://github.com/wespark25/library




Ways to improve this project: 

Implement React js as the GUI. Create CRUD methods to add and delete transaction entries.

