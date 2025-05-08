FROM maven:3.9-eclipse-temurin

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia todo el proyecto al contenedor
COPY . /app

# Compila el proyecto sin ejecutar tests
RUN mvn clean install -DskipTests

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "target/optimizerpc-0.0.1-SNAPSHOT.jar"]

