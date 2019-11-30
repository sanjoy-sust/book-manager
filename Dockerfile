FROM java:8
COPY /build/libs/book-manager-1.0-SNAPSHOT.jar book-manager-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","book-manager-1.0-SNAPSHOT.jar"]