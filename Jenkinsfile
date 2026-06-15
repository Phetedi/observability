pipeline {

    agent any

    tools {
        maven 'Maven-3.9'
    }

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

        stage('Build Application') {

            steps {

                dir('applications/springboot-app/demo') {

                    sh '''
                    mvn clean package
                    '''
                }

            }
        }

    }

}
