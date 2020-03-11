pipeline {
  agent any
  stages {
    stage('Clone') {
      parallel {
        stage('Clone') {
          steps {
            git(url: 'https://github.com/GomesDosSantos/api-restful.git', branch: 'master')
          }
        }

        stage('Wait') {
          steps {
            sleep 5
          }
        }

      }
    }

    stage('Install') {
      steps {
        sh 'pip install -r requirements.txt'
        sh 'python3 -m flask run'
      }
    }

    stage('Teste') {
      environment {
        MENSAGEM = 'legal'
      }
      steps {
        echo '${env.MENSAGEM}'
        sh 'pytest -v'
      }
    }

  }
}