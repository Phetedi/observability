pipeline {

    agent any

    stages {

        stage('Checkout Verification') {

            steps {

                sh '''
                echo "Workspace Information"
                pwd

                echo ""
                echo "Repository Contents"
                ls -la
                '''
            }
        }

    }
}
