FROM maven:3-jdk-8-alpine as MVN_BUILD

WORKDIR /opt/sym/
ADD . /tmp
RUN cd /tmp && mvn package -DskipTests -Pci && mv target/classes/* /opt/sym/ \
    && cp -f /opt/sym/BOOT-INF/classes/ \
    && rm -rf /tmp/* && rm -rf ~/.m2

FROM openjdk:8-alpine

WORKDIR /opt/sym/
COPY --from=MVN_BUILD /opt/sym/ /opt/sym/
RUN apk add --no-cache ca-certificates tzdata

EXPOSE 8080

ENTRYPOINT [ "java", "-cp", "BOOT-INF/lib/*:BOOT-INF/classes"]
