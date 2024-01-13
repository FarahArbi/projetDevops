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
         stage('SonarQube') {
            steps {
                echo 'container SonarQube'
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonarqube'
            }
        }
    }
    
}
