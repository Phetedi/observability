pipeline {

    agent any

    stages {

        stage('Docker Validation') {

            steps {

                sh '''
                whoami
                id

                ls -l /var/run/docker.sock

                docker version
                '''
            }
        }
    }
}
