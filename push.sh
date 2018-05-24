ssh -i "/home/x/Downloads/smartness.pem" ubuntu@ec2-18-219-54-214.us-east-2.compute.amazonaws.com "sudo rm -f /u01/projects/backend/smart.war"


scp -i "/home/x/Downloads/smartness.pem" build/libs/smart-0.0.1-SNAPSHOT.war ubuntu@ec2-18-219-54-214.us-east-2.compute.amazonaws.com:/u01/projects/backend/smart.war

ssh -i "/home/x/Downloads/smartness.pem" ubuntu@ec2-18-219-54-214.us-east-2.compute.amazonaws.com "java -jar smart.war &"


