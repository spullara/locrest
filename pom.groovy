include com.google.GoogleCode
include org.apache.Licenses

project {
    modelVersion "4.0.0"
    groupId "com.sampullara.locrest"
    artifactId "server"
    packaging "war"
    name "LocREST"
    version "1.0-SNAPSHOT"
    url "http://code.google.com/p/locrest"

    googlecode("locrest")
    asl2()

    repositories {
        repository("maven2-repository.dev.java.net", "Java.net Repository for Maven 2", "http://download.java.net/maven/2/")
        legacyrepository("maven-repository.dev.java.net", "Java.net Repository for Maven 1", "http://download.java.net/maven/1/")
    }

    dependencies {
        dependency("com.sun.jersey", "jersey-server", "1.0.3")
        dependency("com.sun.jersey", "jersey-json", "1.0.3")
        dependency("mysql", "mysql-connector-java", "5.1.6")
    }

    build {
        finalName "v1"
        plugins {
            compiler("1.5")
            plugin {
                groupId "org.codehaus.mojo"
                artifactId "tomcat-maven-plugin"
                version "1.0-beta-1"
                configuration {
                  path '/v1'
                }
            }
        }
    }

}