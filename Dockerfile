FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY src/ ./src/
COPY lib/ ./lib/ 
RUN mkdir bin
RUN javac -d bin -cp "lib/*" -sourcepath src $(find src -name "*.java")

FROM eclipse-temurin:17-jre
WORKDIR /app

RUN apt-get update && apt-get install -y \
    libxext6 \
    libxrender1 \
    libxtst6 \
    libxi6 \
    libfreetype6 \
    && rm -rf /var/lib/apt/lists/*

COPY --from=build /app/bin ./bin
COPY --from=build /app/lib ./lib

ENTRYPOINT ["java", "-cp", "bin:lib/*", "Main"]