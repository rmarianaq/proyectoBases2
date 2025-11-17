plugins {
    // Plugin base de Java
    java
    // Plugin de Spring Boot
    id("org.springframework.boot") version "3.4.1"
    // Plugin para gestionar versiones de dependencias de Spring Boot
    id("io.spring.dependency-management") version "1.1.7"
}


group = "co.edu.uniquindio"
version = "0.0.1-SNAPSHOT"
description = " La Universidad del Quindío administra de manera integral la información de sus programas académicos, estudiantes, docentes, asignaturas y matrículas. Con el fin de modernizar su plataforma académica, se requiere diseñar un sistema de base de datos que permita no solo registrar los procesos transaccionales básicos, sino también ejecutar análisis avanzados, garantizar la seguridad de la información, optimizar el almacenamiento físico y complementar la gestión académica con un módulo de retroalimentación estudiantil en una base de datos NoSQL."


java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}


configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}


repositories {
    mavenCentral()
}


dependencies {
    // -----------------------------------------------------------------------------------------
    //  DEPENDENCIAS CRÍTICAS PARA PERSISTENCIA (JPA & NoSQL)
    // -----------------------------------------------------------------------------------------

    // 1. SPRING DATA JPA: Proporciona la interfaz JpaRepository y la integración con Hibernate.
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // 2. SPRING DATA MONGODB: Módulo para la base de datos NoSQL.
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    // 3. DRIVER DE BASE DE DATOS ORACLE: Necesario para la conexión física.
    runtimeOnly("com.oracle.database.jdbc:ojdbc11")

    // -----------------------------------------------------------------------------------------
    //  OTRAS DEPENDENCIAS
    // -----------------------------------------------------------------------------------------

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // LOMBOK: para reducir el código repetitivo (getters, setters, etc.)
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // PRUEBAS
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}


tasks.withType<Test> {
    useJUnitPlatform()
}