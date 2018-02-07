FROM openjdk:8-jre-slim

# Add the jar with all the dependencies
# Maven creates container-test.jar in the target folder of my workspace.
# We need this in some location - say - /usr/share/tag folder of the container
ADD  target/DockerTest-1.0-SNAPSHOT.jar /usr/share/tag/container-test.jar

ADD testng.xml /usr/share/tag/testng.xml

# Command line to execute the test
#ENTRYPOINT ["/usr/bin/java", "-cp", "/usr/share/tag/container-test.jar", "org.testng.TestNG", "-testclass", "GoogleTest"]

ENTRYPOINT /usr/bin/java -cp /usr/share/tag/container-test.jar -DseleniumHubHost=http://192.168.99.100:4444/wd/hub -Dbrowser=chrome org.testng.TestNG /usr/share/tag/testng
