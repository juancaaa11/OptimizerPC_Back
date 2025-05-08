# Usamos una imagen oficial de OpenJDK
FROM openjdk:22-jdk

# Instalamos Maven
RUN apt-get update && apt-get install -y maven

# Copiamos el proyecto dentro del contenedor
COPY . /app

# Configuramos el directorio de trabajo
WORKDIR /app

# Instalamos las dependencias y construimos el proyecto
RUN mvn clean install -DskipTests

# Exponemos el puerto que la aplicación va a usar (por ejemplo, 8080)
EXPOSE 8080

# Ejecutamos el archivo .jar generado por Maven
CMD ["java", "-jar", "target/optimizerpc-0.0.1-SNAPSHOT.jar"]
