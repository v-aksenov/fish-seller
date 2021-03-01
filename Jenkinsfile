pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn test'
                }
            }
        }


        stage ('Run Stage') {
            steps {
                sh 'nohup java -jar /var/lib/jenkins/workspace/Fish-seller-pipeline/target/fish-seller-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}