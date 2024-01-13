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

           stage('Nexus') {
            steps {
                echo 'Déployer vers Nexus (with tests skipped)'
                sh 'mvn deploy -DskipTests'
            }
        }
        
    }
    
}
