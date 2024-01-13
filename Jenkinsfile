pipeline {
    agent any

    stages {
        stage('GIT') {
            steps {
                echo 'Obtenir le projet depuis Git'
                git branch: 'main',
                url: 'https://github.com/FarahArbi/projetDevops.git'
            }
        }

        stage('Compilation') {
            steps {
                echo 'Compiler avec Maven'
                sh 'mvn clean compile package'
            }
        }

          stage('nexus') {
            steps {
                sh 'mvn package'
                nexusArtifactUploader artifacts: [[artifactId: 'achat', classifier: '', file: 'achat-1.0.jar', type: 'jar']], credentialsId: 'f46af45f-4738-4761-ac4f-376ed91108ef', groupId: 'tn', nexusUrl: 'nexus:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-releases', version: '1.0'
            }
        }
       
         stage('SonarQube') {
            steps {
                echo 'container SonarQube'
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar -Dsonar.host.url=http://sonarqube:9000'
            }
        }
    }
    
}
