pipeline {
  agent any
  stages {
    stage('Clone') {
      steps {
        git(url: 'https://github.com/GomesDosSantos/api-restful.git', branch: 'master')
      }
    }

    stage('Environment') {
      steps {
        sh 'pip install --upgrade --no-deps --force-reinstall -r requirements.txt'
      }
    }

    stage('Test') {
      parallel {
        stage('Env') {
          environment {
            MENSAGEM = 'legal'
          }
          steps {
            echo '${env.MENSAGEM}'
          }
        }

        stage('Python3') {
          steps {
            sh '''python -V
python3.8 -V'''
          }
        }

        stage('PyTest') {
          steps {
            sh 'pytest -v'
            sh 'pytest -v | tee pytest-log.log'
          }
        }

      }
    }

    stage('Log') {
      steps {
        readFile 'pytest-log.log'
      }
    }

  }
}