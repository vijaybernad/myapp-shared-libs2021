def call(cred_id,user,ip){
 sshagent([cred_id]) {
      //rename the var file
     sh 'mv target/*.war target/myweb.war'
     //copy file to tomcat server
     sh "scp -o StrictHostKeyChecking=no target/myweb.war ${user}@${ip}:/opt/tomcat8/webapps"
     sh "ssh ${user}@${ip} /opt/tomcat8/bin/shutdown.sh"
     sh "ssh ${user}@${ip} /opt/tomcat8/bin/startup.sh"
  } 
}
