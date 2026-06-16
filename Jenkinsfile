pipeline {

    agent any

    stages {

        stage('Docker Agent Test') {

            agent {
                docker {
                    image 'alpine:latest'
                }
            }

            steps {

                sh '''
                echo "Running inside Docker agent"
                cat /etc/os-release
                '''
            }

        }

    }

}
