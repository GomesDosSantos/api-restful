pipeline {
  agent any
  stages {
    stage('Clone') {
      steps {
        git(url: 'https://github.com/GomesDosSantos/api-restful.git', branch: 'master')
      }
    }

    stage('Conda Enviroment') {
      parallel {
        stage('Environment') {
          steps {
            sh 'conda create -y --name test_env python==3.8'
          }
        }

        stage('Requirements') {
          steps {
            sh 'conda install -y --file requirements.txt'
          }
        }

        stage('Activation') {
          steps {
            sh 'conda activate test_env'
          }
        }

      }
    }

    stage('Test') {
      environment {
        MENSAGEM = 'legal'
      }
      steps {
        echo '${env.MENSAGEM}'
        sh '''python -V
python3.8 -V'''
        sh 'pytest -v'
      }
    }

    stage('Log') {
      steps {
        sh 'conda deactivate test_env'
      }
    }

  }
}