[1]This project is develop using Spring ,Hibernate and Mysql
[2]You need to do following setups to run this project in your system
[A]Run Mysql Script (DbScript/salesinformation.sql)
[B]Setup Maven in your local system
[C]Set resource.property file (Details see in Description document)
[4]Build the project using maven commend:
      D:<yourWorkSpace>\mediaocean>mvn clean install 
       Once you get build successfully 
      You will get war file in mediaoceanRest.war File in target folder
[5]Deploy this war file on  tomacat server
[6]Once deployment done successfull you just need to hit below url :
   http://localhost:8080/mediaoceanRest/salesDetails/get/products/all
    set Header token  AUTHENTICATION_ID =99 else you will not able to access this service
[6]yOU can get service details form Postmancollection
