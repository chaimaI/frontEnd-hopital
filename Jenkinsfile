pipeline{
    agent any
    triggers{
		pollSCM('* * * * *')
	}
    stages{
        stage("Compile the source code")	{
            steps	{
            bat "mvn compile"
            }
        }
      
	stage("Package the application")	{
            steps	{
            bat "mvn clean package -DskipTests"
            }
        }
	
	stage("Deploy to the staging")	{
	    steps	{
	    bat	"mvn spring-boot:run"
	}
	}
    }
}
