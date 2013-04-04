
IXA-pipe-parse
=================

This module uses Apache OpenNLP programatically to provide Constituent Parsing
for English and Spanish. English models have been trained using Penn treebank.
This module is part of IXA-Pipeline ("is a pipeline"), a multilingual NLP pipeline
developed by the IXA NLP Group (ixa.si.ehu.es).

Contents
========

The contents of the module are the following:

    + formatter.xml           Apache OpenNLP code formatter for Eclipse SDK
    + pom.xml                 maven pom file which deals with everything related to compilation and execution of the module
    + src/                    java source code of the module
    + Furthermore, the installation process, as described in the README.md, will generate another directory:
    target/                 it contains binary executable and other directories


INSTALLATION
============

Installing the ixa-pipe-parse requires the following steps:

If you already have installed in your machine JDK6 and MAVEN 3, please go to step 3
directly. Otherwise, follow these steps:

1. Install JDK 1.6
-------------------

If you do not install JDK 1.6 in a default location, you will probably need to configure the PATH in .bashrc or .bash_profile:

````shell
export JAVA_HOME=/yourpath/local/java6
export PATH=${JAVA_HOME}/bin:${PATH}
````

If you use tcsh you will need to specify it in your .login as follows:

````shell
setenv JAVA_HOME /usr/java/java16
setenv PATH ${JAVA_HOME}/bin:${PATH}
````

If you re-login into your shell and run the command

````shell
java -version
````

You should now see that your jdk is 1.6

2. Install MAVEN 3
------------------

Download MAVEN 3 from

````shell
wget http://www.apache.org/dyn/closer.cgi/maven/maven-3/3.0.4/binaries/apache-maven-3.0.4-bin.tar.gz
````

Now you need to configure the PATH. For Bash Shell:

````shell
export MAVEN_HOME=/home/ragerri/local/apache-maven-3.0.4
export PATH=${MAVEN_HOME}/bin:${PATH}
````

For tcsh shell:

````shell
setenv MAVEN3_HOME ~/local/apache-maven-3.0.4
setenv PATH ${MAVEN3}/bin:{PATH}
````

If you re-login into your shell and run the command

````shell
mvn -version
````

You should see reference to the MAVEN version you have just installed plus the JDK 6 that is using.

3. Get module from bitbucket
-------------------------

````shell
hg clone ssh://hg@bitbucket.org/ragerri/ixa-pipe-parse
````

4. Download trained models
--------------------------

You will need to download the trained parser models for the module to work properly. Go to:

````shell
http://ixa2.si.ehu.es/ragerri/ixa-pipe-models
````

Download en-parser-chunking.bin and es-parser-chunking.bin and copy them to ixa-pipe-parse/src/main/resources/.
Note that if you change the name of the models you will need to modify accordingly the source code in Models.java.

5. Move into main directory
---------------------------

````shell
cd ixa-pipe-parse
````

6. Install module using maven
-----------------------------

````shell
mvn clean package
````

This step will create a directory called target/ which contains various directories and files.
Most importantly, there you will find the module executable:

ixa-pipe-parse-1.0.jar

This executable contains every dependency the module needs, so it is completely portable as long
as you have a JVM 1.6 installed.

To install the module in the local maven repository, usually located in ~/.m2/, execute:

````shell
mvn clean install
````

7. USING ixa-pipe-parse
==========================

The program takes KAF documents (with <wf> elements) as standard input and outputs syntactic analysis
in treebank format.

To run the program execute:

````shell
cat wfterms.kaf | java -jar $PATH/target/ixa-pipe-parse-1.0.jar
````

GENERATING JAVADOC
==================

You can also generate the javadoc of the module by executing:

````shell
mvn javadoc:jar
````

Which will create a jar file core/target/ixa-pipe-parse-1.0-javadoc.jar


Contact information
===================

````shell
Rodrigo Agerri
IXA NLP Group
University of the Basque Country (UPV/EHU)
E-20018 Donostia-San Sebastián
rodrigo.agerri@ehu.es
````
