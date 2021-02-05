# digipay-codeChallenge


There is 6 microservices here:

1. config server based on spting cloud configs.

2.registry server based on eureka registry server.

3.zuul gataway as gateway and load balancer

4.payment service

5.notification service

6.documentation service that reads all api's in connected microservices, and gathering it all in one ui, which user can choose between services and see their request requirements.

For sake of simplicity Authorization service skipped.

all api's are written in reactive web via spring webflux

<h3>payment-service explanation:</h3>

this service provides all goals that doc specifies.
getProvider method in BankServiceFactory class decides which implementation of IBankService shoul do the transfer based on requirements of doc.
all api's uses DTO's to send and recieve data.
connecting with notification service is through feignClient and in case of error for sending message or if notification service has been down it uses hystrix and its fallback 
mechanism. 
bank service providers that mentioned in doc has sudo implementaion in codes in case of send true or false responses to transfer requests(one of each three requests will be fail
 by random number in case of produce failure records in database)
 transfer records will be indexed by createdDate for further reports in big scale database records.
 Add delete and findAll api's for cards should be find in DebtCardController.
 Transfer and reports api should be find in DebtCardTransferController.
 all this api's has their own validation group.
 
<h3>notification service explanation:</h3>
 Notification service uses rabbitMq as message broker to insure all messages eventually will be send.
 
 
 
 Docker compose and tests will be add in further pushes.
 postman collection added to root.
 
 
