1. login
Use leader/leader to login as leader, you should be able to see ticket of your team. A toolbar will be available for you to update the records
Use admin/admin to login as admin, you should be able to see all the valid tickets (read only)
Use member1/member1 to login as a common user, you will see ticket of your team but there will be no toolbar for you to edit

2. Edit
Leader role will have a toolbar after login. "New" and "Delete" are not implemented for they are out of scope. 
"Edit" and Save will only be available if before the month deadline. Deadline is defaulted as 5th according to requirement, however you can update "dealine.day=5" in application.properties

3. Data
Mock data is under resource/db. Please note that data will be refreshed everytime. You can update the datasource url in application.properties if you donot want this.

4.Test case
Testases are under src/test/java, following maven/gradle structure

5. TODOs
There are todo tags in the code indicates there are some items can be enhanced in future but simplified at the moment.
