node{
   stage('Checkout')
   {
             checkout scm
     }
   stage('Build')
    
   {
      sh """cd EurekaDiscoveryServer
            mvn clean install 
      """
      //mvn clean install 
      //cd ../MentorProfile
      //mvn clean install
      //cd ../Payments
      //mvn clean install
      //cd ../SkillsTechnologies
      //mvn clean install
      //cd ../SpringBootJwtAuthentication
      //mvn clean install
      //cd ../Trainings
      //mvn clean install
      //cd ../UserProfile
      //mvn clean install
      //cd ../ZuulService     
   }
   
    } 
