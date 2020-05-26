FROM openjdk:8-jre-slim
MAINTAINER Ravi Singh
RUN mkdir /usr/src/myapp
ADD target/SPRINGBOOTBACKEND-1.0-SNAPSHOT.jar /usr/src/myapp
WORKDIR /usr/src/myapp
CMD ["java","-cp","SPRINGBOOTBACKEND-1.0-SNAPSHOT.jar","com/spe/ecommerce/EcommerceApplication"]
