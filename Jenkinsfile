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
       
         stage('SonarQube') {
            steps {
                echo 'container SonarQube'
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar -Dsonar.host.url=http://sonarqube:9000'
            }
        }
            stage('nexus') {
            steps {
                sh 'mvn package'
                nexusArtifactUploader artifacts: [[artifactId: 'achat', classifier: '', file: 'target/achat-1.0.jar', type: 'jar']], credentialsId: 'nexus', groupId: 'tn', nexusUrl: 'nexus:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-releases', version: '1.0'
            }
        }

        stage('Build and Push Docker Images') {
            steps {
                echo 'Building and pushing Docker images'
                 // Build Spring Boot project Docker image
            script {
                 // Install Docker in the Jenkins container
                    sh 'sudo apt-get update'
                    sh 'sudo apt-get install -y docker.io'
                    sh 'docker --version'

                    // Build and push Docker images
                    def imageName = 'springboot-devops'
                    sh "mvn package"
                    sh "docker build -t $imageName ."
                    sh "docker tag $imageName faraharbi/$imageName:latest"
                    sh "docker login -u faraharbi -p dckr_pat_UUq3d58bRGZ0-L8c5S9e811Iuoo"
                    sh "docker push faraharbi/$imageName:latest"
                }
            }
        }
   
    }
    
}
