pipeline {

    agent {
        docker {
            image 'maven:3.9.9-eclipse-temurin-17'
        }
    }

    stages {

        stage('Build Application') {

            steps {

                sh '''
                java -version
                mvn -version

                cd applications/springboot-app/demo

                mvn clean package
                '''
            }
        }
    }
}
