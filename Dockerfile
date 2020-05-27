FROM openjdk:8-jre-slim
MAINTAINER Ravi Singh
RUN mkdir /usr/src/myapp
ADD target/ecommerce-0.0.1-SNAPSHOT.jar /usr/src/myapp
WORKDIR /usr/src/myapp
CMD ["java","-cp","ecommerce-0.0.1-SNAPSHOT/com/spe/ecommerce","EcommerceApplication"]