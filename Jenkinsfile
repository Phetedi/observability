pipeline {

    agent {
	tools {
            maven 'Maven-3.9'
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
