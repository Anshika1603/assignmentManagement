# assignmentManagement

We have created 3 APIs with the following functionalities:

# Intern API: 
- Add new intern 
- Get all interns 
- Get intern detail 
- Update intern info 
- Remove intern 
- Submit assignment 
 
# Mentor API: 
- Add new mentor 
- Get all mentors 
- Get mentor detail 
- Update Mentor info 
- Remove mentor 
- Create assignment 
 
# Admin API 
- Assign mentor to intern 
- Reassign mentor 
- Add KIP/KUP plan 
- Update KIP/KUP plan

In the backed services we are using Azure SQL database and Azure CosmoDB for performing the database operations.
We have also used a ServiceBus, Topic, Publisher and Subscriber to publish message as soon as a Assignment is created 
by the mentor. It is subscribed by a subscriber named intern. 

We have used Azure ServiceBusTriggerFunction to trigger and send logs as soon as a message is recieved in the topic.
