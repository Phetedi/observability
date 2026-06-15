pipeline {

    agent any

    tools {
        maven 'Maven-3.9'
    }

    stages {

        stage('Environment Check') {
            steps {
                sh '''
                java -version
                mvn -version
                '''
            }
        }

        stage('Build Application') {
            steps {
                dir('applications/springboot-app/demo') {
                    sh 'mvn clean package'
                }
            }
        }

    }

    post {

        success {

            archiveArtifacts(
                artifacts: 'applications/springboot-app/demo/target/*.jar',
                fingerprint: true
            )

        }

    }

}
