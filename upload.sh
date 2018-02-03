ssh -i "/Users/nicholasramos/Downloads/smart.pem" ec2-user@ec2-18-218-238-56.us-east-2.compute.amazonaws.com "sudo rm -f /usr/share/tomcat/webapps/smart.war"

scp -i "/Users/nicholasramos/Downloads/smart.pem" build/libs/smart-0.0.1-SNAPSHOT.war ec2-user@ec2-18-218-238-56.us-east-2.compute.amazonaws.com:/usr/share/tomcat/webapps/smart.war
