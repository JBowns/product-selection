# Product Selection
Sky Technology Unattended Programming Test

# Introduction
This application consists of an backend service written in Java 8 using Spring Framework 4, and a front end client written in Polymer.

#Building

## Server-side
The application can be built as a Jar using 'mvn install' which will also embed all the relevant dependencies.

The application contains an embedded tomcat instance and can be run independently of your IDE.

## Client-side

To build Polymer from source

1. Navigate to 'cd src/main/resources/public'
2. Install bower 'npm install --global bower'
3. Install the bower dependencies 'bower install'

Please also note the client is being served as static content from within the Jar.
