node{
   stage('Checkout')
   {
             checkout scm
     }
   stage('Build')
    
   {
      sh """cd EurekaDiscoveryServer
            mvn clean install -DskipTests
            cd ../MentorProfile
            mvn clean install -DskipTests
            cd ../Payments
            mvn clean install -DskipTests
            cd ../SkillsTechnologies
            mvn clean install -DskipTests
            cd ../SpringBootJwtAuthentication
            mvn clean install -DskipTests
            cd ../Trainings
            mvn clean install -DskipTests
            cd ../UserProfile
            mvn clean install -DskipTests
            cd ../ZuulService
            mvn clean install -DskipTests
      """
      
   }
   
   
   
    } 
