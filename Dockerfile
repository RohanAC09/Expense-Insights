FROM maven:3.8.5-openjdk-17 as part-1
WORKDIR /app
COPY Expense-Insights /app
RUN --mount=type=cache,target=/root/.m2 \
    mvn clean package -DskipTests -s settings.xml
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

ENV SF_TEMPORARY_CREDENTIAL_CACHE_DIR=/tmp/.cache/snowflake
ENV SF_OCSP_RESPONSE_CACHE_DIR=/tmp/.cache/snowflake
ENV SPARK_LOCAL_HOSTNAME=localhost
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]