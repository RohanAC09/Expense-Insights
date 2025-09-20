FROM maven:3.8.5-openjdk-17 as part-1
WORKDIR /app
COPY ./ /app
RUN --mount=type=cache,target=/root/.m2 \
    mvn clean package -DskipTests
RUN java -Djarmode=layertools -jar target/Expense-Insights-*.jar extract

EXPOSE 9001

FROM alpine/java:17-jre
WORKDIR /app

COPY --from=part-1 /app/spring-boot-loader ./
COPY --from=part-1 /app/dependencies ./
COPY --from=part-1 /app/snapshot-dependencies ./
COPY --from=part-1 /app/application ./

RUN adduser -D rohan && chown -R rohan /app && chmod -R a+x /app
USER rohan

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
