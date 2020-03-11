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
        sh 'conda create -y --name test_env python==3.8'
        sh 'conda install -y --file requirements.txt'
        sh 'conda activate test_env'
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
          }
        }

      }
    }

    stage('Log') {
      steps {
        sh 'conda deactivate test_env'
      }
    }

  }
}