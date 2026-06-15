pipeline {

    agent any

    stages {

        stage('Environment Check') {

            steps {

                sh '''
                echo "Java Version"
                java -version

                echo ""
                echo "Maven Version"
                mvn -version
                '''
            }
        }

    }
}
