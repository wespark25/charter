![Screen Shot 2021-04-16 at 11 32 41 AM](https://user-images.githubusercontent.com/43556685/115061019-31af4400-9eae-11eb-9edf-4dbb8f2f7369.png)

How to Use:

Set up  a local database with the information provided in /charter/src/main/resources/application.properties.
 

Then all you need to do is run the application and open localhost:8080 on a web browser.



 


because of constraints with how the dummy data was generated new Customers were being created based on uniqueness of name instead of their unique ID. This would be easily rectified with more time.

A better example of robust Spring Boot architecture is my launchCode project

This application decides to assign a customer points based on if the date of the transaction is within the past three months of the csv file being imported. A future improvement would be to have it dynamically remove points as soon as the date becomes older than three months.

Things to improve this project: 
