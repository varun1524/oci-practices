#FROM odo-docker-signed-local.artifactory.oci.oraclecorp.com/oci-oel7x-jdk11:1.0.296
FROM docker-remote.artifactory.oci.oraclecorp.com/oraclelinux:7-slim
COPY --from=odo-docker-signed-local.artifactory.oci.oraclecorp.com/odo/base-image-support:ol7x-1.6 / /
ENTRYPOINT ["/sbin/simple_init.py"]

RUN yum install yum-plugin-versionlock && \
    yum-config-manager --add-repo https://artifactory.oci.oraclecorp.com/graalvm-release-yum-local/ && \
    yum install --setopt=obsoletes=0 graalvm21-ee-11-jdk && \
    yum versionlock 'graalvm*' && \
    yum clean all

COPY /target/lib/META-INF/com.fnproject.fn/runtime/native/libfnunixsocket.so /function/runtime/lib/
RUN chmod 777 /function/runtime/lib/libfnunixsocket.so

# copy application jar
COPY target/*.jar /function/app/

# copy certificate
#COPY certs/*.crt /function/certs/

# adding certificate to cacerts
#RUN export JAVA_HOME=$(readlink -f /usr/bin/java | sed "s:bin/java::") \
#    && cp /function/certs/missioncontrol-root-ca.crt $JAVA_HOME/lib/security \
#    && cd $JAVA_HOME/lib/security \
#    && keytool -import -trustcacerts -cacerts \
#          -storepass changeit -noprompt -alias missioncontrol-root-ca -file missioncontrol-root-ca.crt

ENTRYPOINT [ "/usr/bin/java", "-XX:+UseSerialGC",  \
     "-Djava.awt.headless=true" , \
     "-Djava.library.path=/function/runtime/lib", \
     "-cp", "/function/app/*:/function/runtime/*:/function/app:/function/app/resources", \
     "com.fnproject.fn.runtime.EntryPoint" ]

WORKDIR /function
CMD ["org.example.HelloFunction::handleRequest"]