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
    }
}
