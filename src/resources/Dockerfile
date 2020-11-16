FROM gocd/gocd-agent-centos-7:v20.9.0

MAINTAINER Ali Rahimi <ali.rahimi@ikor.de>
ENV JAVA_HOME /gocd-jre
ENV GRADLE_HOME /opt/gradle/gradle-6.7
ENV PATH="/gocd-jre/bin:${PATH}"
ENV PATH="/opt/gradle/gradle-6.7/bin:${PATH}"
USER root
RUN yum install -y wget
RUN yum clean all
RUN wget https://services.gradle.org/distributions/gradle-6.7-bin.zip -P /tmp
RUN unzip -d /opt/gradle /tmp/gradle-6.7-bin.zip
RUN gradle -v

USER go
