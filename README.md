# Distributed tracing using sleuth and zipkin
TraceID: a unique value different for different http request, that will be added as header to each requests. 

## How to add
- spring-cloud-sleuth (Adds traceid and span id in the request headers)
- spring-cloud-zipkin (for viewing trace info, like which request went to which microservice and how much time it took)
```
	
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-sleuth</artifactId>
		</dependency>
		<!-- Zipkin start -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-zipkin</artifactId>
		</dependency>
		<!-- end -->

```

Add the following in application.yml
--------------------------------------
```
spring:
  sleuth:
    enabled: true
    sampler:
      probability: 1.0
  zipkin:
    baseUrl: https://ps-zipkin-server.cfapps.io
    enabled: true
    sender:
      type: web

```

Artifacts deployed in PCF:
- app1
- app2 
- zipkin server (https://ps-zipkin-server.cfapps.io)

App1 microservice calls App2 microservice 

# How to test:

1. Hit the below url

http://trace-app1.cfapps.io/client/tracetest 

2. View zipkin trace information using the below urls. 
https://ps-zipkin-server.cfapps.io

This shows all requests how much time each service took to process the requests. 

## view logs
- cf logs trace-app1
- cf logs trace-app2

trace format [appname, traceid, spanid] - 

-  INFO [Application 1,ba428bb01be1476c,ba428bb01be1476c,true] 16 --- [nio-8080-exec-4] i.t.l.testapp1.service.ClientController  : Inside App 1 Controller : 
-  INFO [Application 1,ba428bb01be1476c,ba428bb01be1476c,true] 16 --- [nio-8080-exec-4] i.test.log.testapp1.service.TestService  : Test Service method called

The logs has the traceid used to identify the requests across different microservices, we may further use firehose to externalize the logs to view it in one common place using other services. 



