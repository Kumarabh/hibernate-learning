## Hibernate object states
```
Transition - 
Persistent
Detached
Removed
```
**Transition** <br>
  Object is created using getter/ setter but not session.save is not called
  ```
  customer.setCustomerName("John Doe");
  ```

**Persistent** <br>
  Object is saved in session using session.save, it writes the data into database.
  ```
  session.save(customer);
  ```

**Detached** <br>
  Session is cleared using or closed. Data is stored in database but it's not associated with the session.
  ```
  Transaction tsx = session.beginTransaction();
  session.setCustomerName("John Doe");
  tsx.commit();
  session.close();

  session.setCustomeName("James Smith"); // Will not take James Smith
  factory.close();
  ```

**Removed** <br>
  Object is removed from database, but associated with session
